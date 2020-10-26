package com.cn.thytest.service.login.impl;

import com.alibaba.fastjson.JSONObject;
import com.cn.common.exception.FzlException;
import com.cn.common.utils.myString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.base.pmJwtToken;
import com.cn.thytest.dao.login.LoginDao;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * @Author fengzhilong
 * @Date 2020/9/24 15:12
 * @Desc
 **/
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;
    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 登录系统
     * @Date 2020/9/24 15:21
     * @Param [user]
     * @return com.cn.common.vo.ResResult
    **/
    @Override
    public ResResult verification(User user) throws FzlException, UnsupportedEncodingException {

        User content = loginDao.findByUidAndPwd(user.getUid(), myString.base64Encode(user.getPwd()));
        if (content == null){
            //content = loginDao.findByLoginNameAndPwd(user.getUid(), myString.base64Encode(user.getPwd()));
            log.info("【"+user.getUid()+"】-> 账号或密码错误");
            return ResCode.ERROR.msg("账号或密码错误");
        }else {
            log.info("【"+user.getUid()+"】-> 登录成功");

            ResResult resResult = ResCode.OK.msg("登录成功")
                    .putData("content", content);
            String strJson = JSONObject.toJSONString(resResult);
            String strToken = pmJwtToken.getJwtToken(user.getUid(), strJson);
            return ResCode.OK.msg("登录成功")
                    .putData("content", content)
                    .putData("loginToken", strToken);
        }
    }

    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 验证token
     * @Date 2020/9/25 16:32
     * @Param [strPostData]
     * @return com.cn.common.vo.ResResult
    **/
    @Override
    public ResResult getPmagent(String strPostData) throws FzlException{

        JSONObject json = JSONObject.parseObject(strPostData);
        String strToken = json.getString("TOKEN");
        String strData = pmJwtToken.getPmAgent(strToken);

        return ResCode.OK.msg("验证成功")
                .putData("content", strData);
    }
}
