package com.cn.thytest.dao.sysmenu;

import com.cn.thytest.entity.sysmenu.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 19:03
 * @Desc //TODO
 **/
@Repository
public interface SysMenuDao extends JpaRepository<SysMenu, Integer> {

    //获取1级菜单
    @Query("select sm from SysMenu sm where sm.visible = 1 and sm.pId = '0' order by sm.id asc ")
    List<SysMenu> getMenu1Data();


    //根据获取下一级级菜单
    @Query("select sm from SysMenu sm where sm.visible = 1 and sm.pId =:pId order by sm.id asc ")
    List<SysMenu> getMenuByPIdData(@Param("pId") String pId);
}
