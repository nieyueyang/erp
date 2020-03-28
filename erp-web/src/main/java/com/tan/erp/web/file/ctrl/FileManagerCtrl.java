package com.tan.erp.web.file.ctrl;

import com.tan.erp.common.dto.Result;
import com.tan.erp.common.enums.ErrorMsgEnum;
import com.tan.erp.common.exception.GlobalException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

/**
 * @Author: nieyy
 * @Date: 2020/2/18 20:43
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileManagerCtrl {

    @Value("${file.upload.root}")
    private String filePath;

    @PostMapping("/upload")
    public Result uploaded(@RequestParam("file") MultipartFile file) throws GlobalException, IOException {

        if (file.isEmpty()) {
            GlobalException exception = new GlobalException(ErrorMsgEnum.FILEUOLOADFAIL);
            throw exception;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = fileName.replace(suffixName, "");
        //生成文件名称通用方法
        String newFilePath = filePath + "/images/" + fileName + Instant.now().toEpochMilli() + suffixName;
        //String newFileName = fileName +Instant.now().toEpochMilli() + suffixName;

        // 保存文件
        byte[] bytes = file.getBytes();
        Path path = Paths.get(newFilePath);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, bytes);

        return new Result(newFilePath);
    }

}
