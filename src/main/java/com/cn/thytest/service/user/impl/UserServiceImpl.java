package com.cn.thytest.service.user.impl;

import com.cn.common.utils.myString;
import com.cn.common.vo.ResCode;
import com.cn.common.vo.ResResult;
import com.cn.thytest.dao.user.UserDao;
import com.cn.thytest.dto.user.GroupsMemerDTO;
import com.cn.thytest.dto.user.UserPageDTO;
import com.cn.thytest.entity.login.User;
import com.cn.thytest.service.user.UserService;
import com.cn.thytest.utils.PageUtil;
import com.cn.thytest.vo.JpaUtil;
import com.cn.thytest.vo.Pageparam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    private JpaUtil jpaUtil;

    @PersistenceContext
    private EntityManager entityManager;

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
        //Page<GroupsMemerDTO> page = jpaUtil.page(hql, params, pageable, GroupsMemerDTO.class);

        Query query = entityManager.createQuery(hql);
        if (params != null){
            Iterator<String> iterator = params.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                query.setParameter(key, params.get(key));
            }
        }

        if (pageable.isPaged()){
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }

        String cHql = QueryUtils.createCountQueryFor(hql);
        System.out.println("----   " + cHql);
        TypedQuery<Long> cQuery = (TypedQuery)entityManager.createQuery(cHql);
        if (params != null) {
            Iterator var8 = params.keySet().iterator();

            while(var8.hasNext()) {
                String key = (String)var8.next();
                cQuery.setParameter(key, params.get(key));
            }
        }

        return PageableExecutionUtils.getPage(query.getResultList(), pageable, ()->{
            return executeCountQuery(cQuery);
        });

        /*User user = new User();
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
        Page<User> page = userDao.findAll(specification,pageable);*/
    }


    private static Long executeCountQuery(TypedQuery<Long> query) {
        Assert.notNull(query, "TypedQuery must not be null!");
        List<Long> totals = query.getResultList();
        Long total = 0L;

        Long element;
        for(Iterator var3 = totals.iterator(); var3.hasNext(); total = total + (element == null ? 0L : element)) {
            element = (Long)var3.next();
        }

        return total;
    }

    @Override
    public ResResult addUser(User user) {
        if (myString.isNotEmpty(user.getUid())){
            userDao.saveAndFlush(user);
        }

        return ResCode.OK.msg("添加成功");
    }
}
