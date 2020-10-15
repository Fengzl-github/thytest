package com.cn.thytest.dao.topic;

import com.cn.thytest.entity.topic.ExamTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author fengzhilong
 * @Date 2020/9/30 17:09
 * @Desc //TODO
 **/
@Repository
public interface ExamTopicDao extends JpaRepository<ExamTopic, Integer>,JpaSpecificationExecutor {


    @Transactional
    @Modifying
    @Query("update ExamTopic et set et.status=:status where et.tpId=:tpId")
    int removeTopic(@Param("tpId") String tpId, @Param("status") Integer status);


    @Transactional
    @Modifying
    @Query("delete from ExamTopic et where et.tpId=:tpId")
    int deleteTopic(@Param("tpId") String tpId);

}
