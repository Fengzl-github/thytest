package com.cn.thytest.service.user.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.cn.common.jpa.util.PageUtil;
import com.cn.common.jpa.vo.Pageparam;
import com.cn.common.utils.MyString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.user.GroupsDao;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.Groups;
import com.cn.thytest.service.user.GroupsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author fengzhilong
 * @Date 2020/10/20 14:45
 * @Desc //TODO
 **/
@Service
public class GroupsServiceImpl implements GroupsService {

    @Resource
    private GroupsDao groupsDao;


    @Override
    public ResResult getGroupsPage(UserPageDTO userPageDTO) {
        Pageparam pageparam = new Pageparam();
        pageparam.setPagesize(userPageDTO.getPagesize());
        pageparam.setCurrentPage(userPageDTO.getCurrentPage());

        Specification<Groups> specification = new Specification<Groups>() {
            @Override
            public Predicate toPredicate(Root<Groups> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (userPageDTO.getGroupId() > 0 ){
                    predicateList.add(criteriaBuilder.equal(root.get("gid"), userPageDTO.getGroupId()));
                }
                if (MyString.isNotEmpty(userPageDTO.getGroupName())){
                    predicateList.add(criteriaBuilder.like(root.get("gName"), "%" + userPageDTO.getGroupName()+"%"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        Pageable pageable = PageUtil.getPageable(pageparam.getCurrentPage(), pageparam.getPagesize(), "gid");

        Page page = groupsDao.findAll(specification, pageable);

        return ResCode.OK
                .putData("content", page.getContent())
                .putData("total", page.getTotalElements());
    }

    @Override
    public Groups addGroups(Groups groups) {

        return groupsDao.saveAndFlush(groups);
    }

    @Override
    public ResResult getGroupsOptions() {

        List<Groups> list = groupsDao.findAll();

        return ResCode.OK.putData("content", list);
    }
}
