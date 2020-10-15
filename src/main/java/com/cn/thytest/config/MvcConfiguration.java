package com.cn.thytest.config;

import com.cn.thytest.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 16:32
 * @Desc //TODO MVC配置类
 **/
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {


    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 注册登录拦截器
     * @Date 2020/9/25 17:05
     * @Param []
     * @return com.cn.thytest.interceptor.LoginInterceptor
    **/
    @Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }
    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 自定义拦截器
     * @Date 2020/9/25 17:06
     * @Param [registry]
     * @return void
    **/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
