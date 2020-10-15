package com.cn.thytest.controller;

import com.cn.common.exception.FzlException;
import com.cn.thytest.annotation.PassToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author fengzhilong
 * @Date 2020/9/24 11:00
 * @Desc
 **/
@Controller
public class IndexController {

    //测试
    @PassToken
    @RequestMapping("/test/test")
    public String test() throws FzlException{
        return "test/test";
    }
    //测试抽屉
    @PassToken
    @RequestMapping("/test/testct")
    public String testct() throws FzlException{
        return "test/testct";
    }

    //登录页面
    @PassToken
    @RequestMapping("/")
    public String login() throws FzlException {
        return "index";
    }

    //导航页
    @PassToken
    @RequestMapping("/myindex")
    public String index() throws FzlException{
        return "myindex";
    }

    //首页
    @PassToken
    @RequestMapping("/main")
    public String mainPage() throws FzlException{
        return "main";
    }

    //user
    @PassToken
    @RequestMapping("/user/userlist")
    public String userList() throws FzlException{
        return "user/userlist";
    }

    //题库
    @PassToken
    @RequestMapping("/topic/topiclist")
    public String topicList() throws FzlException{
        return "/topic/topiclist";
    }


}
