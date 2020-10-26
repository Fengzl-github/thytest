package com.cn.thytest.service.user.impl;

import com.cn.common.jpa.util.JpaUtil;
import com.cn.common.jpa.util.PageUtil;
import com.cn.common.jpa.vo.Pageparam;
import com.cn.common.utils.myString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.user.GroupMemberDao;
import com.cn.thytest.dao.user.UserDao;
import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.GroupMember;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 18:05
 * @Desc //TODO
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private GroupMemberDao groupMemberDao;

    @Autowired
    private JpaUtil jpaUtil;

    @Override
    public Page<GroupsMemerDTO> getUserListData(UserPageDTO userPageDTO) {

        String hql = "select new com.cn.thytest.dto.user.GroupsMemerDTO(u,g,gm) from User u " +
                "left join GroupMember gm on u.uid=gm.uid " +
                "left join Groups g on g.gid=gm.gid " +
                "where 1=1 ";

        Map<String, Object> params = new HashMap<>();
        if (myString.isNotEmpty(userPageDTO.getUid())){
            hql += "and u.uid=:uid ";
            params.put("uid", userPageDTO.getUid());
        }
        if (myString.isNotEmpty(userPageDTO.getUname())){
            hql += "and u.uName=:uName ";
            params.put("uName", userPageDTO.getUname());
        }
        Pageparam pageparam = new Pageparam();
        pageparam.setPagesize(userPageDTO.getPagesize());
        pageparam.setCurrentPage(userPageDTO.getCurrentPage());
        Pageable pageable = PageUtil.getPageable(pageparam.getCurrentPage(), pageparam.getPagesize(), "u.uid");
        Page<GroupsMemerDTO> page = jpaUtil.page(hql, params, pageable, GroupsMemerDTO.class);

       return page;

    }



    @Override
    public ResResult saveUser(GroupsMemerDTO groupsMemerDTO) throws UnsupportedEncodingException {
        if (myString.isNotEmpty(groupsMemerDTO.getUser().getUid())){
            User byUid = userDao.findByUid(groupsMemerDTO.getUser().getUid());
            byUid.setUid(groupsMemerDTO.getUser().getUid());
            byUid.setLoginName(groupsMemerDTO.getUser().getLoginName());
            byUid.setUName(groupsMemerDTO.getUser().getUName());
            byUid.setTel(groupsMemerDTO.getUser().getTel());
            byUid.setEmail(groupsMemerDTO.getUser().getEmail());
            byUid.setSex(groupsMemerDTO.getUser().getSex());
            byUid.setAge(groupsMemerDTO.getUser().getAge());
            byUid.setAddr(groupsMemerDTO.getUser().getAddr());
            if (myString.isEmpty(groupsMemerDTO.getUser().getPwd())){
                //新增用户添加默认密码
                byUid.setPwd(myString.base64Encode("1234"));
            }
            userDao.saveAndFlush(byUid);

            GroupMember groupMember = groupMemberDao.findByUid(byUid.getUid());
            if (groupMember == null){

            }
            return ResCode.OK.msg("保存成功");
        }else {
            return ResCode.ERROR.msg("uid不能为空");
        }
    }
}
