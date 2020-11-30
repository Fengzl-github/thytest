package com.cn.thytest.controller.exam;

import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.exam.ExamPlanDTO;
import com.cn.thytest.entity.exam.ExamPlan;
import com.cn.thytest.service.exam.ExamPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 16:05
 * @Desc //TODO
 **/

@RestController
@RequestMapping("/exam/plan")
public class ExamPlanController {

    @Autowired
    private ExamPlanService examPlanService;


    @PostMapping("/getExamPlanList")
    public ResResult getExamPlanList(ExamPlanDTO examPlanDTO){

        return examPlanService.getExamPlanList(examPlanDTO);
    }

    //添加、修改计划
    @PostMapping("/saveExamPlan")
    public ResResult saveExamPlan(@RequestBody ExamPlan examPlan){

        return examPlanService.saveExamPlan(examPlan);
    }

    //删除计划
    @PostMapping("/delExamPlan")
    public ResResult delExamPlan(String planId){

        return examPlanService.delExamPlan(planId);
    }
}
