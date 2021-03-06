package com.gitee.cobra.spring.annotation;


import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CobraRequestParam {
    String value() default "";
}
