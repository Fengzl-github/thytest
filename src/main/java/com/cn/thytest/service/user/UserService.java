package com.cn.thytest.service.user;

import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.vo.Pageparam;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 18:05
 * @Desc //TODO
 **/
@Validated
public interface UserService {
    Page<GroupsMemerDTO> getUserListData(UserPageDTO userPageDTO);

    ResResult addUser(User user);
}
