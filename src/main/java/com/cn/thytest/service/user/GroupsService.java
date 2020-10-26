package com.cn.thytest.service.user;

import com.cn.common.vo.ResResult;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.Groups;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @Author fengzhilong
 * @Date 2020/10/20 14:44
 * @Desc //TODO
 **/
@Validated
public interface GroupsService {

    ResResult getGroupsPage(UserPageDTO userPageDTO);

    Groups addGroups(Groups groups);

    ResResult getGroupsOptions();
}
