package com.cn.thytest.dao.login;

import com.cn.thytest.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author fengzhilong
 * @Date 2020/9/24 15:12
 * @Desc
 **/
@Repository
public interface LoginDao extends JpaRepository<User, Integer> {

    User findByUidAndPwd(String uid, String pwd);
}
