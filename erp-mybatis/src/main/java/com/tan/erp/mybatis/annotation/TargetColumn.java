package com.tan.erp.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @Author: nieyy
 * @Date: 2020/3/6 20:56
 * @Version 1.0
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetColumn {
    String value() default "";
}
