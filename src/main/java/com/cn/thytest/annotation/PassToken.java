package com.cn.thytest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 17:08
 * @Desc //TODO 自定义注解，跳过拦截器验证jwt的token数据
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {

    boolean required() default true;
}
