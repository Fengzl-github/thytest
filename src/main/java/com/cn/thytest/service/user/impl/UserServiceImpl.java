package com.cn.thytest.service.user.impl;

import com.cn.common.utils.myString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.user.UserDao;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.user.UserService;
import com.cn.thytest.utils.PageUtil;
import com.cn.thytest.vo.Pageparam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ResResult getUserListData(UserPageDTO userPageDTO) {

        User user = new User();
        user.setUid(userPageDTO.getUid());
        user.setUName(userPageDTO.getUname());
        Pageparam pageparam = new Pageparam();
        pageparam.setPagesize(userPageDTO.getPagesize());
        pageparam.setCurrentPage(userPageDTO.getCurrentPage());
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (myString.isNotEmpty(user.getUid())){
                    predicateList.add(criteriaBuilder.like(root.get("uid"), user.getUid()+"%"));
                }
                if (myString.isNotEmpty(user.getUName())){
                    predicateList.add(criteriaBuilder.like(root.get("uName"), "%"+user.getUName()+"%"));
                }

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        Pageable pageable = PageUtil.getPageable(pageparam.getCurrentPage(), pageparam.getPagesize(), "uid");
        Page<User> page = userDao.findAll(specification,pageable);
        return ResCode.OK.msg("查询成功")
                .putData("total", page.getTotalElements())
                .putData("content", page.getContent());
    }

    @Override
    public ResResult addUser(User user) {
        if (myString.isNotEmpty(user.getUid())){
            userDao.saveAndFlush(user);
        }

        return ResCode.OK.msg("添加成功");
    }
}
