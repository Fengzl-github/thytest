package com.cn.thytest.dto.user;

import lombok.Data;


/**
 * @Author fengzhilong
 * @Date 2020/9/28 16:41
 * @Desc //TODO
 **/
@Data
public class UserPageDTO {

    private String uid;

    private String uname;

    private String pwd;

    private int role;

    private int age;

    private String sex;

    private int groupId;

    private String groupName;

    private int isDel;

    private Integer pagesize; //每页数
    private Integer currentPage; //当前页
    private Integer total; //总数
}
