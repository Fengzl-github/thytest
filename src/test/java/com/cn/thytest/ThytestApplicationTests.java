package com.cn.thytest;


import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.exam.ExamPlanDTO;
import com.cn.thytest.service.exam.ExamPlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThytestApplicationTests {

    @Autowired
    private ExamPlanService examPlanService;

    @Test
    void contextLoads() {

        //添加、修改考试计划
       /* ExamPlan examPlan = new ExamPlan();
        examPlan.setPlanName("考试计划3");
        examPlan.setPlanStarttime("20201130140000");
        examPlan.setPlanEndtime("20201130160000");
        examPlan.setOperator("超管");
        ResResult resResult = examPlanService.saveExamPlan(examPlan);
        System.out.println(resResult.getCode()+"----->");*/
        /*ResResult resResult = examPlanService.delExamPlan("P202011301717107524");
        System.out.println(resResult.getCode()+"----->");*/
        ExamPlanDTO examPlanDTO = new ExamPlanDTO();
        examPlanDTO.setCurrentPage(0);
        examPlanDTO.setPagesize(10);

        ResResult examPlanList = examPlanService.getExamPlanList(examPlanDTO);
        System.out.println(examPlanList.getData("content"));

    }

}
