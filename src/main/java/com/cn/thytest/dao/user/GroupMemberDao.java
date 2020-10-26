package com.cn.thytest.dao.user;

import com.cn.thytest.entity.login.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author fengzhilong
 * @Date 2020/10/20 17:53
 * @Desc //TODO
 **/
@Repository
public interface GroupMemberDao extends JpaRepository<GroupMember, Integer> {

    //根据uid修改数据
    @Transactional
    @Modifying
    @Query("update GroupMember gm set gm.uid=:uid, gm.role=:role, gm.uName=:uName where gm.uid=:uid")
    Integer updateMemberDataByuid(@Param("uid") String uid, @Param("role") Integer role, @Param("uName") String uName);




    //根据gid修改数据
    @Transactional
    @Modifying
    @Query("update GroupMember gm set gm.gid=:gid, gm.gName=:gName where gm.gid=:gid")
    Integer updateMemberDataBygid(@Param("gid") Integer gid, @Param("gName") String gName);


    @Query("select gm from GroupMember gm where gm.uid = :uid")
    GroupMember findByUid(@Param("uid") String uid);
}
