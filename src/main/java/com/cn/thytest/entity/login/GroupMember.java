package com.cn.thytest.entity.login;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author fengzhilong
 * @Date 2020/10/16 17:21
 * @Desc //TODO
 **/
@Data
@Entity
@Table(name = "t_group_member")
public class GroupMember {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(columnDefinition = "int(4) UNSIGNED NOT NULL COMMENT '组号'")
    private Integer gid;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '组名'")
    private String gName;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '账号'")
    private String uid;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '姓名'")
    private String uName;

    @Column(columnDefinition = "int(4) UNSIGNED DEFAULT 1 COMMENT '角色：1 普通账号，2 管理员，3 超级管理员'")
    private int role;
}
