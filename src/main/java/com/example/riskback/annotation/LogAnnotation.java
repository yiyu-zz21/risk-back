package com.example.riskback.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String operModel() default ""; //操作模块

    String operType() default ""; //操作类型

    String operDesc() default ""; //操作说明
}
