package com.cn.thytest.controller.user;

import com.cn.common.utils.OutputToExcel;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.annotation.PassToken;
import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.service.user.GroupsService;
import com.cn.thytest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private GroupsService groupsService;


    /**
     * @Author fengzhilong
     * @Desc //TODO 账号信息列表
     * @Date 2020/10/12 14:32
     * @Param [userPageDTO]
     * @return com.cn.common.vo.ResResult
     **/
    @PostMapping("/getuserlistdata")
    public ResResult getUserListData(@RequestBody UserPageDTO userPageDTO) {
        Page<GroupsMemerDTO> page = userService.getUserListData(userPageDTO);

        return ResCode.OK
                .putData("content", page.getContent())
                .putData("tatol", page.getTotalElements());


    }

    /**
     * @Author fengzhilong
     * @Desc //TODO 获取组信息
     * @Date 2020/10/21 16:15
     * @Param []
     * @return com.cn.common.vo.ResResult
     **/
    @RequestMapping("/getGroupsData")
    public ResResult getGroupsData() {

        return groupsService.getGroupsOptions();
    }

    /**
     * @Author fengzhilong
     * @Desc //TODO 保存账号信息(新增和修改)
     * @Date 2020/10/12 14:36
     * @Param [userPageDTO]
     * @return com.cn.common.vo.ResResult
     **/
    @PostMapping("/saveUser")
    public ResResult saveUser(@RequestBody GroupsMemerDTO groupsMemerDTO) throws UnsupportedEncodingException {
        return userService.saveUser(groupsMemerDTO);
    }


    @PassToken
    @GetMapping("/download")
    public ResResult outPutExcel(HttpServletRequest request) {
        OutputToExcel.downThisPage("用户列表", "测试", null, null);

        return ResCode.OK.msg("下载成功");
    }
}
