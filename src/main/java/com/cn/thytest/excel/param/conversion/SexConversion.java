package com.cn.thytest.excel.param.conversion;

import com.cn.common.excel.param.conversion.DataExportConversion;

/**
 * @Author fengzhilong
 * @Date 2020/12/20 12:18
 * @Desc
 */
public class SexConversion implements DataExportConversion<String> {
    @Override
    public String transferData(String data) {
        if (data.equals("1")){
            return "男";
        }else if (data.equals("2")) {
            return "女";
        }else {
            return "不详";
        }
    }
}
