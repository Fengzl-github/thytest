package com.cn.thytest.dao.exam;

import com.cn.thytest.entity.exam.ExamPlan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author fengzhilong
 * @Date 2020/11/30 15:45
 * @Desc //TODO
 **/
@Repository
public interface ExamPlanDao extends JpaRepository<ExamPlan, Integer>, JpaSpecificationExecutor {


    /* 根据planID查询*/
    @Query("select ep from ExamPlan ep where ep.planId = :planId")
    ExamPlan findByPlanId(@Param("planId") String planId);


    /*根据planID删除*/
    @Transactional
    @Modifying
    @Query("delete from ExamPlan ep where ep.planId= :planId")
    void delExamPlan(@Param("planId") String planId);

}
