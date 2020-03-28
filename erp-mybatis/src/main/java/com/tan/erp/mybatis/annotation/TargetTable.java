package com.tan.erp.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @Author: nieyy
 * @Date: 2020/3/6 20:54
 * @Version 1.0
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetTable {
    String value() default "";
}
