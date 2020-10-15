package com.cn.thytest.dao.user;

import com.cn.thytest.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 18:07
 * @Desc //TODO
 **/
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor {


}
