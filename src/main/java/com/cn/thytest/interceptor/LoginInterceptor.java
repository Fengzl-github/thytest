package com.cn.thytest.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cn.thytest.annotation.PassToken;
import com.cn.thytest.base.pmJwtToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 16:41
 * @Desc //TODO 登录拦截器
 **/
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");


        //如果不是映射到方法直接通过
        //System.out.println(handler);
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method  method = handlerMethod.getMethod();
        //System.out.println(method);
        //检查是否有PassToken注解，有跳过拦截
        if (method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }

        //获取token并认证
        String token = request.getHeader("token");
        if (token == null){
            System.out.println("无token，请重新登录");
            return false;
        }

        //获取token中的uid
        String uid = "";
        try {
            uid = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException e){
            System.out.println("token失效或异常，请重新登录");
            return false;
        }

        //验证token的合法性
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(pmJwtToken.jwtTokenSecret)).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTVerificationException e){
            System.out.println("token失效或非法，请重新登录");
            return false;
        }

        return true;
    }
}
