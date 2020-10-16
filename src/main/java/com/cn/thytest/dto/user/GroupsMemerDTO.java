package com.cn.thytest.dto.user;

import com.cn.thytest.entity.login.GroupMember;
import com.cn.thytest.entity.login.Groups;
import com.cn.thytest.entity.login.User;
import lombok.Data;

/**
 * @Author fengzhilong
 * @Date 2020/10/16 17:36
 * @Desc //TODO
 **/
@Data
public class GroupsMemerDTO {

    private User user;
    private Groups group;
    private GroupMember groupMember;


    public GroupsMemerDTO(User user, Groups group, GroupMember groupMember) {
        this.user = user;
        this.group = group;
        this.groupMember = groupMember;
    }
}
