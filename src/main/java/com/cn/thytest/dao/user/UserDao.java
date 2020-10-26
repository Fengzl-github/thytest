package com.cn.thytest.dao.user;

import com.cn.thytest.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 18:07
 * @Desc //TODO
 **/
@Repository
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor {

    @Query("select u from User u where u.uid=:uid")
    User findByUid(@Param("uid") String uid);

}
