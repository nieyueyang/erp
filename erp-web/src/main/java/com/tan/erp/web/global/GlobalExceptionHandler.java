package com.tan.erp.web.global;

import com.tan.erp.common.dto.Result;
import com.tan.erp.common.enums.ErrorMsgEnum;
import com.tan.erp.common.enums.ErrorUserMsgEnum;
import com.tan.erp.common.exception.GlobalException;
import com.tan.erp.common.exception.UserException;
import com.tan.erp.common.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLWarning;

@RestController
public class GlobalExceptionHandler extends AbstractErrorController {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }


    @RequestMapping(value = "/error")
    public void error(HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        Throwable throwable = getCause(request);
        if (throwable != null) {
            result = defaultErrorHandler((Exception) throwable);
        } else {
            int httpCode = response.getStatus();
            if (httpCode == 400) {
                result.setCode(ErrorMsgEnum.PARAM_NOT_FOUND.getCode());
                result.setMsg(ErrorMsgEnum.PARAM_NOT_FOUND.getMsg());
            } else if (httpCode == 403) {
                result.setCode(ErrorUserMsgEnum.AUTHORIZATION_NOT_FOUND.getCode());
                result.setMsg(ErrorUserMsgEnum.AUTHORIZATION_NOT_FOUND.getMsg());
            } else if (httpCode == 404) {
                result.setCode(ErrorMsgEnum.NOT_FOUND.getCode());
                result.setMsg(ErrorMsgEnum.NOT_FOUND.getMsg());
            } else if (httpCode == 405) {
                result.setCode(ErrorMsgEnum.NOT_FOUND.getCode());
                result.setMsg(ErrorMsgEnum.NOT_FOUND.getMsg());
            } else if (httpCode == 500) {
                result.setCode(ErrorMsgEnum.INTERNAL_SERVER_ERROR.getCode());
                result.setMsg(ErrorMsgEnum.INTERNAL_SERVER_ERROR.getMsg());
            } else {
                result.setCode(ErrorMsgEnum.UnknowErrorMsg.getCode());
                result.setMsg(ErrorMsgEnum.UnknowErrorMsg.getMsg());
            }
        }
        HttpUtil.responseWriteJson(response, result);
    }

    private Result defaultErrorHandler(Exception ex) {
        Result result = new Result();
        if (ex instanceof UserException) {
            result.setCode(((UserException) ex).getExceptionCode());
            result.setMsg(((UserException) ex).getExceptionMsg());

        } else if (ex instanceof GlobalException) {
            result.setCode(((GlobalException) ex).getGlobalExceptionCode());
            result.setMsg(((GlobalException) ex).getGlobalExceptionMsg());
        }else if(ex instanceof SQLException){
            SQLException sqlException = (SQLException) ex;
            int sqlErroeCode = sqlException.getErrorCode();
            if (sqlErroeCode == 1062){
                String[] errorMessages = sqlException.getMessage().split("'");
                String messages = errorMessages[1];
                result.setCode(ErrorMsgEnum.SQL_UNIQUE.getCode());
                result.setMsg(messages + ":  数据不能重复");
            }else{
                result.setCode(ErrorMsgEnum.SQL_Error.getCode());
                result.setMsg(ErrorMsgEnum.SQL_Error.getMsg());
            }

        } else {
            result.setCode(ErrorMsgEnum.UnknowErrorMsg.getCode());
            result.setMsg(ErrorMsgEnum.UnknowErrorMsg.getMsg());
        }
        return result;
    }

    private Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
            while (error instanceof Exception && error.getCause() != null) {
                error = error.getCause();
            }
        }
        return error;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}