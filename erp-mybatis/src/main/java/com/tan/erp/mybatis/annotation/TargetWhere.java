package com.tan.erp.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @Author: nieyy
 * @Date: 2020/3/8 14:59
 * @Version 1.0
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetWhere {
    String value() default "";
}
