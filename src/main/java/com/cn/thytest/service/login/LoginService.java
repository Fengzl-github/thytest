package com.cn.thytest.service.login;

import com.cn.common.vo.ResResult;
import com.cn.thytest.entity.login.User;
import org.springframework.validation.annotation.Validated;

import java.io.UnsupportedEncodingException;

/**
 * @Author fengzhilong
 * @Date 2020/9/24 15:11
 * @Desc
 **/
@Validated
public interface LoginService {

    //登录
    ResResult verification(User user);

    //验证token
    ResResult getPmagent(String strPostData);
}
