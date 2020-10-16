package com.cn.thytest.entity.sysmenu;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Target;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 10:07
 * @Desc //TODO 系统菜单表
 **/
@Entity
@Data
@Table(name = "crm_menu_bs")
public class SysMenu {

    @Id
    @Column(columnDefinition = "varchar(10) NOT NULL COMMENT '菜单id'", unique = true)
    private String id;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '菜单名'")
    private String title;

    @Column(columnDefinition = "varchar(80) DEFAULT '' COMMENT '连接地址'")
    private String url;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '图标'")
    private String icon;

    @Column(columnDefinition = "varchar(10) DEFAULT 0 COMMENT '上级id'")
    private String pId;

    @Column(columnDefinition = "int(4) UNSIGNED DEFAULT 3 COMMENT '等级：1 普通账号展示菜单 2 管理员账号 3 全部展示'")
    private Integer level;

    @Column(columnDefinition = "int(4) UNSIGNED DEFAULT 1 COMMENT '是否可见：0 隐藏，1 可见'")
    private Integer visible;
}
