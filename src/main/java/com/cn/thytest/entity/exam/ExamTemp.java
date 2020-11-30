package com.cn.thytest.entity.exam;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 14:42
 * @Desc //TODO 考试模板表 (在考试计划下)
 **/
@Data
@Entity
@Table(name = "t_exam_temp")
public class ExamTemp {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '模板Id'", unique = true)
    private String tempId;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '模板名称'")
    private String tempName;

    @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '计划id'")
    private String planId;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '创建时间'")
    private String createTime;

    @Column(columnDefinition = "varchar(30) NOT NULL COMMENT '操作人'")
    private String operator;
}
