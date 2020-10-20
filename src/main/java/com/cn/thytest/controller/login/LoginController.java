package com.cn.thytest.controller.login;

import com.cn.common.exception.FzlException;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.annotation.PassToken;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @Author fengzhilong
 * @Date 2020/9/24 14:51
 * @Desc
 **/
@RestController
@RequestMapping("/sys/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 登录系统
     * @Date 2020/9/24 15:19
     * @Param [user]
     * @return com.cn.common.vo.ResResult
    **/
    @PassToken
    @PostMapping("/verification")
    public ResResult verification(@RequestBody User user) throws FzlException, UnsupportedEncodingException {

        return loginService.verification(user);
    }

    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 检测token
     * @Date 2020/9/25 16:32
     * @Param [strPostData]
     * @return com.cn.common.vo.ResResult
    **/
    @PostMapping("/verification/get_pmagent")
    public ResResult getPmagent(@RequestBody String strPostData) throws FzlException{
        if (strPostData == ""){
            return ResCode.ERROR.msg("参数有误");
        }
        else {
            return loginService.getPmagent(strPostData);
        }
    }
    

}
