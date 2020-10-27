package com.cn.thytest.dao.user;

import com.cn.thytest.entity.login.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author fengzhilong
 * @Date 2020/10/20 14:41
 * @Desc //TODO
 **/
@Repository
public interface GroupsDao extends JpaRepository<Groups, Integer>, JpaSpecificationExecutor {

    @Query("select g from Groups g where g.gid= :gid ")
    Groups findByGid(@Param("gid") Integer gid);


}
