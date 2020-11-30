package com.cn.thytest.entity.exam;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 14:53
 * @Desc //TODO 考生答案/阅卷表
 **/
@Data
@Entity
@Table(name = "t_exam_paper")
public class ExamPaper {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '题目id'")
    private String tpId;

    @Column(columnDefinition = "varchar(10) NOT NULL COMMENT '考生id'")
    private String uid;

    @Column(columnDefinition = "varchar(30) NOT NULL COMMENT '考生姓名'")
    private String uname;

    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '考生答案'")
    private String candidateAnswer;

    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '判卷人id'")
    private String judUid;
    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '判卷人姓名'")
    private String judName;

    @Column(columnDefinition = "varchar(30) DEFAULT '' COMMENT '判卷时间'")
    private String judTime;

    @Column(columnDefinition = "varchar(30) DEFAULT 0 COMMENT '分数'")
    private String score;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '创建时间'")
    private String createTime;




}
