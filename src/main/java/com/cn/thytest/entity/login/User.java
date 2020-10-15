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
    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false)
    private String uName;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private int role;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private int groupId;

    @Column(nullable = false)
    private int isDel;

}
