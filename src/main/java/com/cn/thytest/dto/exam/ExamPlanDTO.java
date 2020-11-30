package com.cn.thytest.dto.exam;

import lombok.Data;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 16:12
 * @Desc //TODO
 **/
@Data
public class ExamPlanDTO {
    private Integer id;

    private String planId;

    private String planName;

    private String PlanStarttime;

    private String PlanEndtime;

    private String createTime;

    private String operator;

    private Integer pagesize; //每页数
    private Integer currentPage; //当前页
    private Integer total; //总数

    /*-------------------------------------------------------------------------------------------------------*/

    private String planStartdate;
    private String planEnddate;
}
