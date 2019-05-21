package com.gitee.cobra.spring.annotation;

import java.lang.annotation.*;

// 目标类型
@Target({ElementType.TYPE})
// 作用域
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CobraController {
    String value() default "";
}
