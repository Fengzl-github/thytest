package com.cn.thytest;

import com.cn.common.utils.DateTime;
import com.cn.common.utils.myString;
import com.cn.thytest.service.user.GroupsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
class ThytestApplicationTests {

    @Autowired
    private GroupsService groupsService;


    @Test
    void contextLoads() throws UnsupportedEncodingException {

        /*Groups groups = new Groups();
        groups.setGid(4);
        groups.setGName("业务组4444");
        groupsService.addGroups(groups);*/
        String s = myString.base64Encode("1234");
        System.out.println(s);

    }

}
