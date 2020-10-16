package com.cn.thytest.entity.login;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author fengzhilong
 * @Date 2020/10/16 17:16
 * @Desc //TODO
 **/
@Data
@Entity
@Table(name = "t_group")
public class Groups {

    @Id
    @Column(columnDefinition = "int(4) UNSIGNED NOT NULL COMMENT '组号'", unique = true)
    private Integer gid;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '组名'")
    private String gName;

}
