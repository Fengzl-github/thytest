package com.cn.thytest;

import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
class ThytestApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {

        UserPageDTO userPageDTO = new UserPageDTO();
        userPageDTO.setPagesize(10);
        userPageDTO.setCurrentPage(0);

        Page<GroupsMemerDTO> userListData = userService.getUserListData(userPageDTO);
        System.out.println(userListData.getContent());

    }

}
