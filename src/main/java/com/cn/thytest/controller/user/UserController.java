package com.cn.thytest.controller.user;

import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.service.user.GroupsService;
import com.cn.thytest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResResult getUserListData(@RequestBody UserPageDTO userPageDTO){
        Page<GroupsMemerDTO> page = userService.getUserListData(userPageDTO);

        //List<UserPageDTO> list = new ArrayList<>();
        List<GroupsMemerDTO> list = page.getContent();
        /*for (GroupsMemerDTO content : cont){
            UserPageDTO userPageDTO1 = new UserPageDTO();
            userPageDTO1.setUid(content.getUid());
            userPageDTO1.setUname(content.getUName());
            userPageDTO1.setPwd(content.getPwd());
            userPageDTO1.setAge(content.getAge());
            userPageDTO1.setSex(content.getSex());
            userPageDTO1.set(content.getSex());
            userPageDTO1.setIsDel(content.getIsDel());

            if (content.getGid() != null){
                userPageDTO1.setGroupId(content.getGid());
            }
            userPageDTO1.setGroupName(content.getGName());

            userPageDTO1.setRole(content.getRole());

            list.add(userPageDTO1);

        }*/
        return ResCode.OK
                .putData("content", list)
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
    public ResResult getGroupsData(){
        
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
}
