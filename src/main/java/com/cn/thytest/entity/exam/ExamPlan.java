package com.cn.thytest.entity.exam;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 14:28
 * @Desc //TODO 考试计划表
 **/
@Data
@Entity
@Table(name = "t_exam_plan")
public class ExamPlan {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '计划Id'", unique = true)
    private String planId;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '计划名称'")
    private String planName;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '计划开始时间'")
    private String PlanStarttime;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '计划结束时间'")
    private String PlanEndtime;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '创建时间'")
    private String createTime;

    @Column(columnDefinition = "varchar(30) NOT NULL COMMENT '操作人'")
    private String operator;

}
