package com.cn.thytest.service.sysmenu.impl;

import com.alibaba.fastjson.JSONArray;
import com.cn.common.exception.FzlException;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.sysmenu.SysMenuDao;
import com.cn.thytest.entity.sysmenu.SysMenu;
import com.cn.thytest.service.sysmenu.SysMenuService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 19:01
 * @Desc //TODO 获取系统菜单信息
 **/
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuDao sysMenuDao;

    @Override
    public ResResult getMenuData() throws FzlException {
        List<SysMenu> menuData = sysMenuDao.getMenu1Data();

        JSONArray json = getJsonListFormat(menuData);
        System.out.println(json);
        return ResCode.OK.msg("获取成功")
                .putData("content", json);
    }


    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 菜单信息转成json数组格式
     * @Date 2020/9/27 11:59
     * @Param [menuData]
     * @return com.alibaba.fastjson.JSONArray
    **/
    public JSONArray getJsonListFormat(List<SysMenu> menuData){

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        SysMenu menu = null;
        String menuId = "";
        for (int i = 0; i< menuData.size(); i++){
            menu = menuData.get(i);
            menuId = menu.getId();

            if (i > 0) sb.append(",");
            sb.append("{");
            sb.append("\"id\": \""+menuId+"\", ");
            sb.append("\"title\": \""+menu.getTitle()+"\", ");
            sb.append("\"icon\": \""+menu.getIcon()+"\", ");
            sb.append("\"url\": \""+menu.getUrl()+"\", ");
            //是否有下一级菜单
            List<SysMenu> menuByPIdData = sysMenuDao.getMenuByPIdData(menuId);
            String strMenu2 = "";
            if (menuByPIdData != null){
                strMenu2 = getJsonFormatMenu2(menuByPIdData);
            }
            sb.append("\"children\": ["+strMenu2+"]");

            sb.append("}");
        }

        sb.append("]");
        JSONArray jsonArray = JSONArray.parseArray(sb.toString());
        return jsonArray;
    }


    /*
    *
     * @Author fengzhilong
     * @Desc //TODO 获取二级菜单
     * @Date 2020/9/27 13:32
     * @Param [menu2Data]
     * @return java.lang.String
    **/
    public String getJsonFormatMenu2(List<SysMenu> menu2Data){
        StringBuilder sb = new StringBuilder();
        SysMenu menu = null;
        String menuId = "";

        for (int i = 0; i< menu2Data.size(); i++){
            menu = menu2Data.get(i);
            menuId = menu.getId();

            if (i > 0) sb.append(",");
            sb.append("{");
            sb.append("\"id\": \""+menuId+"\", ");
            sb.append("\"title\": \""+menu.getTitle()+"\", ");
            sb.append("\"icon\": \""+menu.getIcon()+"\", ");
            sb.append("\"url\": \""+menu.getUrl()+"\"");


            sb.append("}");
        }

        return sb.toString();
    }
}
