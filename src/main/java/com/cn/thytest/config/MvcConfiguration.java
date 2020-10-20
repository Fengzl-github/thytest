package com.cn.thytest.config;

import com.cn.thytest.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 16:32
 * @Desc //TODO MVC配置类
 **/
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {

    /*//解决中文乱码
    @Bean
    public HttpMessageConverter responseBodyConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }*/

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
