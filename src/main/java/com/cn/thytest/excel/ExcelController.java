package com.cn.thytest.excel;

import com.cn.common.excel.DownloadExcel;
import com.cn.thytest.annotation.PassToken;
import com.cn.thytest.dao.user.UserDao;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.excel.param.UserExportParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/12/20 11:11
 * @Desc
 */
@RestController
public class ExcelController {

    @Autowired
    private UserDao userDao;


    @PassToken
    @GetMapping("/getExcel")
    public void testExcelDown(HttpServletResponse response) {

        //数据信息
        List<User> list = userDao.findAll();
        UserExportParam exportParam = new UserExportParam(list);
        DownloadExcel downloadExcel = new DownloadExcel();

        downloadExcel.downLoad("用户信息", exportParam, response);
    }
}
