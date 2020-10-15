package com.cn.thytest.dto.user;

import com.cn.thytest.entity.login.User;
import com.cn.thytest.vo.Pageparam;
import lombok.Data;

import javax.persistence.Column;

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

    private int isDel;

    private Integer pagesize; //每页数
    private Integer currentPage; //当前页
    private Integer total; //总数
}
