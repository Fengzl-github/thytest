package com.cn.thytest.dto.user;

import com.cn.common.utils.myString;
import com.cn.thytest.entity.login.GroupMember;
import com.cn.thytest.entity.login.Groups;
import com.cn.thytest.entity.login.User;
import lombok.Data;

import javax.persistence.Column;

/**
 * @Author fengzhilong
 * @Date 2020/10/16 17:36
 * @Desc //TODO
 **/
@Data
public class GroupsMemerDTO {

    /*User*/
    private String uid;
    private String loginName;
    private String uName;
    private String pwd;
    private String tel;
    private String email;
    private String addr;
    private int age;
    private String sex;
    private int isDel;
    /*Groups*/
    private Integer gid;
    private String gName;
    /*GroupMember*/
    private int role;

    public GroupsMemerDTO() {
    }

    public GroupsMemerDTO(User user, Groups group, GroupMember groupMember) {
        this.uid = user.getUid();
        if (myString.isNotEmpty(user.getLoginName())){
            this.loginName = user.getLoginName();
        }
        this.uName = user.getUName();
        this.pwd = user.getPwd();
        this.tel = user.getTel();
        this.email = user.getEmail();
        this.addr = user.getAddr();
        this.age = user.getAge();
        this.sex = user.getSex();
        this.isDel = user.getIsDel();

        if (group != null){
            this.gid = group.getGid();
            this.gName = group.getGName();
        }
        if (groupMember != null){
            this.role = groupMember.getRole();
        }
    }
}
