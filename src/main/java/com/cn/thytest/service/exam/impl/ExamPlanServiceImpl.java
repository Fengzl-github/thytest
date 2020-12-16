package com.cn.thytest.service.exam.impl;

import com.cn.common.jpa.util.PageUtil;
import com.cn.common.utils.DateTime;
import com.cn.common.utils.MyString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.exam.ExamPlanDao;
import com.cn.thytest.dto.exam.ExamPlanDTO;
import com.cn.thytest.entity.exam.ExamPlan;
import com.cn.thytest.service.exam.ExamPlanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 15:38
 * @Desc //TODO
 **/
@Service
public class ExamPlanServiceImpl implements ExamPlanService {


    @Resource
    private ExamPlanDao examPlanDao;


    @Override
    public ResResult getExamPlanList(ExamPlanDTO examPlanDTO) {

        Specification<ExamPlan> specification = new Specification<ExamPlan>() {
            @Override
            public Predicate toPredicate(Root<ExamPlan> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicateList = new ArrayList<>();
                if (MyString.isNotEmpty(examPlanDTO.getPlanName())){
                    predicateList.add(criteriaBuilder.like(root.get("planName"), "%"+examPlanDTO.getPlanName()+"%"));
                }
                if (MyString.isNotEmpty(examPlanDTO.getOperator())){
                    predicateList.add(criteriaBuilder.like(root.get("operator"), "%"+examPlanDTO.getOperator()+"%"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        Pageable pageable = PageUtil.getPageable(examPlanDTO.getCurrentPage(), examPlanDTO.getPagesize(), "createTime");
        Page<ExamPlan> page = examPlanDao.findAll(specification, pageable);


        return ResCode.OK.msg("查询成功")
                .putData("content", page.getContent())
                .putData("total", page.getTotalElements());
    }

    @Override
    public ResResult saveExamPlan(ExamPlan examPlan) {
        if (examPlan != null) {
            //修改
            if (MyString.isNotEmpty(examPlan.getPlanId())) {
                ExamPlan byPlanId = examPlanDao.findByPlanId(examPlan.getPlanId());
                //添加主键id
                examPlan.setId(byPlanId.getId());
            } else { //新增
                //添加planId
                String planId = "P" + DateTime.Now().ToString("yyyyMMddHHmmss") + MyString.getRandom(4);
                examPlan.setPlanId(planId);
                examPlan.setCreateTime(DateTime.Now().ToString("yyyyMMddHHmmss"));
            }
            examPlanDao.saveAndFlush(examPlan);

            return ResCode.OK.msg("操作成功");
        } else {
            return ResCode.ERROR.msg("缺少参数");
        }
    }

    @Override
    public ResResult delExamPlan(String planId) {
        if (MyString.isNotEmpty(planId)){

            examPlanDao.delExamPlan(planId);

            return ResCode.OK.msg("删除成功");
        }else {

            return ResCode.ERROR.msg("缺少参数");
        }
    }
}
