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
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column
    private String url;

    @Column
    private String icon;

    @Column(nullable = false)
    private String pId;

    @Column(nullable = false)
    private Integer isDel;
}
