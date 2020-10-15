package com.cn.thytest.controller.sysmenu;

import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.service.sysmenu.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 18:45
 * @Desc //TODO 获取系统菜单
 **/
@RestController
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @PostMapping("/sys/getMenuData")
    public ResResult getMenuData(){

        return sysMenuService.getMenuData();
    }
}
