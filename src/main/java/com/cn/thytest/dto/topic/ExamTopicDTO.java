package com.cn.thytest.dto.topic;

import lombok.Data;

import javax.persistence.Column;

/**
 * @Author fengzhilong
 * @Date 2020/9/30 17:07
 * @Desc //TODO
 **/
@Data
public class ExamTopicDTO {

    private String tpId;

    private String tpName;

    private Integer tpType;

    private Integer tpDifficultyLevel;

    private Integer status;

    private String tpCorrectAnswer;

    private String createTime;

    private String uid;

    private String founder;

    private Integer pagesize; //每页数
    private Integer currentPage; //当前页
    private Integer total; //总数
}
