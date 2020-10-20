package com.cn.thytest.controller.user;

import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     * @Author fengzhilong
     * @Desc //TODO 账号信息列表
     * @Date 2020/10/12 14:32
     * @Param [userPageDTO]
     * @return com.cn.common.vo.ResResult
    **/
    @PostMapping("/getuserlistdata")
    public ResResult getUserListData(@RequestBody UserPageDTO userPageDTO){
        Page<GroupsMemerDTO> page = userService.getUserListData(userPageDTO);

        List<UserPageDTO> list = new ArrayList<>();
        List<GroupsMemerDTO> cont = page.getContent();
        for (GroupsMemerDTO content : cont){
            UserPageDTO userPageDTO1 = new UserPageDTO();
            userPageDTO1.setUid(content.getUser().getUid());
            userPageDTO1.setUname(content.getUser().getUName());
            userPageDTO1.setPwd(content.getUser().getPwd());
            userPageDTO1.setAge(content.getUser().getAge());
            userPageDTO1.setSex(content.getUser().getSex());
            userPageDTO1.setIsDel(content.getUser().getIsDel());
            if (content.getGroupMember() != null){
                userPageDTO1.setGroupId(content.getGroupMember().getGid());
                userPageDTO1.setGroupName(content.getGroupMember().getGName());
                userPageDTO1.setRole(content.getGroupMember().getRole());
            }

            list.add(userPageDTO1);

        }
        return ResCode.OK
                .putData("content", list)
                .putData("tatol", page.getTotalElements());


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
