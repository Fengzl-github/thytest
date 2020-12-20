package com.cn.thytest.excel.param;

import com.cn.common.excel.param.BaseParam;
import com.cn.common.excel.param.ColumnParam;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.excel.param.conversion.SexConversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/12/20 11:04
 * @Desc
 */
public class UserExportParam extends BaseParam<User> {

    public UserExportParam(List<User> list) {
        setData(list);
        setColumnParams(setColumnParam());
    }


    private List<ColumnParam> setColumnParam() {
        List<ColumnParam> columnParams = new ArrayList<>();
        columnParams.add(new ColumnParam("uid", "uid"));
        columnParams.add(new ColumnParam("昵称", "loginName"));
        columnParams.add(new ColumnParam("姓名", "UName"));
        columnParams.add(new ColumnParam("电话", "tel"));
        columnParams.add(new ColumnParam("EMAIL", "email"));
        columnParams.add(new ColumnParam("地址", "addr"));
        columnParams.add(new ColumnParam("年龄", "age"));//0：常规，1：超量
        columnParams.add(new ColumnParam("性别", "sex", new SexConversion()));
        return columnParams;
    }
}
