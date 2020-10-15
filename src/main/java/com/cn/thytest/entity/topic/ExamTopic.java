package com.cn.thytest.entity.topic;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author fengzhilong
 * @Date 2020/9/30 16:08
 * @Desc //TODO 题库
 **/
@Entity
@Data
@Table(name = "crm_exam_topic")
public class ExamTopic {

    @Id
    @Column(columnDefinition = "varchar(18) NOT NULL COMMENT '题目id'", unique = true)
    private String tpId;

    @Column(columnDefinition = "varchar(500) NOT NULL COMMENT '题干'")
    private String tpName;

    @Column(columnDefinition = "TINYINT(4) UNSIGNED DEFAULT 1 NULL COMMENT '题目类型：1 单选，2 多选，3 填空，4 判断，5 简答' ")
    private Integer tpType;

    @Column(columnDefinition = "TINYINT(4) UNSIGNED DEFAULT 3 NULL COMMENT '难度等级：1 特别简单，2 简单，3 一般，4 困难，5 特别困难'")
    private Integer tpDifficultyLevel;

    @Column(columnDefinition = "TINYINT(4) UNSIGNED DEFAULT 0 NULL COMMENT '状态：0 正常，1 过时不用'")
    private Integer status;

    @Column(columnDefinition = "varchar(4000) NOT NULL COMMENT '正确答案'")
    private String tpCorrectAnswer;

    @Column(columnDefinition = "varchar(16) DEFAULT NULL COMMENT '创建时间'")
    private String createTime;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '创建人uid'")
    private String uid;

    @Column(columnDefinition = "varchar(50) NOT NULL COMMENT '创建人姓名'")
    private String founder;

}
