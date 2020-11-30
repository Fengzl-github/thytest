package com.cn.thytest.entity.exam;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 14:48
 * @Desc //TODO 模板中题目表(在考试模板下)
 **/
@Data
@Entity
@Table(name = "t_exam_question")
public class ExamQuestion {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '模板id'")
    private String tempId;
    @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '题目id'")
    private String tpId;

    @Column(columnDefinition = "varchar(500) NOT NULL COMMENT '题干'")
    private String tpName;

    @Column(columnDefinition = "TINYINT(4) UNSIGNED DEFAULT 1 NULL COMMENT '题目类型：1 单选，2 多选，3 填空，4 判断，5 简答' ")
    private Integer tpType;

    @Column(columnDefinition = "TINYINT(4) UNSIGNED DEFAULT 3 NULL COMMENT '难度等级：1 特别简单，2 简单，3 一般，4 困难，5 特别困难'")
    private Integer tpDifficultyLevel;

    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项A'")
    private String optionA;
    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项B'")
    private String optionB;
    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项B'")
    private String optionC;
    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项D'")
    private String optionD;
    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项E'")
    private String optionE;
    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项F'")
    private String optionF;
    @Column(columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '选项G'")
    private String optionG;

    @Column(columnDefinition = "varchar(4000) NOT NULL COMMENT '正确答案'")
    private String tpCorrectAnswer;


    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '创建时间'")
    private String createTime;

    @Column(columnDefinition = "varchar(30) NOT NULL COMMENT '操作人'")
    private String operator;
}
