package com.cn.thytest.entity.login;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author fengzhilong
 * @Date 2020/9/24 14:58
 * @Desc
 **/
@Entity
@Data
@Table(name = "t_user")
public class User {

    @Id
    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '账号'", unique = true)
    private String uid;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '登录名'")
    private String loginName;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '姓名'")
    private String uName;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '密码'")
    private String pwd;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '手机号'")
    private String tel;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '地址'")
    private String addr;

    @Column(columnDefinition = "int(4) UNSIGNED DEFAULT 0 COMMENT '年龄'")
    private int age;

    @Column(columnDefinition = "varchar(10) DEFAULT '' COMMENT '性别'")
    private String sex;

    @Column(columnDefinition = "int(4) UNSIGNED DEFAULT 0 COMMENT '是否删除：0 正常，1 删除'")
    private int isDel;

}
