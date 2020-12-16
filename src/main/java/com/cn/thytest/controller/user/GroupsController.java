package com.cn.thytest.controller.user;

import com.cn.common.utils.MyString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.Groups;
import com.cn.thytest.service.user.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/10/20 14:50
 * @Desc //TODO
 **/
@RestController
@RequestMapping("/user")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @RequestMapping("/getGroupsPage")
    public ResResult getGroupsPage(@RequestBody UserPageDTO userPageDTO){
        return groupsService.getGroupsPage(userPageDTO);
    }

    @RequestMapping("/addGroups")
    public ResResult addGroups(@RequestBody Groups groups){

        if (groups.getGid() != null && groups.getGid() > 0 && MyString.isNotEmpty(groups.getGName())){
            groupsService.addGroups(groups);
            return ResCode.OK.msg("保存成功");
        }else {
            return ResCode.ERROR.msg("缺少参数或参数有误");
        }
    }
}
