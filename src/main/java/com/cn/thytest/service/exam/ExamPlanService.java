package com.cn.thytest.service.exam;

import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.exam.ExamPlanDTO;
import com.cn.thytest.entity.exam.ExamPlan;
import org.springframework.validation.annotation.Validated;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 14:24
 * @Desc //TODO
 **/
@Validated
public interface ExamPlanService {

    //考试计划列表
    ResResult getExamPlanList(ExamPlanDTO examPlanDTO);

    //添加、修改考试计划
    ResResult saveExamPlan(ExamPlan examPlan);

    //删除考试计划 - 关联删除计划下模板和考题、申诉
    ResResult delExamPlan(String planId);






}
