package com.cn.thytest.controller.user;

import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 14:09
 * @Desc //TODO
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * @Author fengzhilong
     * @Desc //TODO 账号信息列表
     * @Date 2020/10/12 14:32
     * @Param [userPageDTO]
     * @return com.cn.common.vo.ResResult
    **/
    @PostMapping("/getuserlistdata")
    public ResResult getUserListData(@RequestBody UserPageDTO userPageDTO){
         userService.getUserListData(userPageDTO);
         return ResCode.OK;


    }


    /**
     * @Author fengzhilong
     * @Desc //TODO 添加账号
     * @Date 2020/10/12 14:36
     * @Param [userPageDTO]
     * @return com.cn.common.vo.ResResult
    **/
    @PostMapping("/addUser")
    public ResResult addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
