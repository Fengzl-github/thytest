package com.cn.thytest.vo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author fengzhilong
 * @Date 2020/10/16 18:23
 * @Desc //TODO
 **/
@Transactional(
        readOnly = true
)
@Repository
public class JpaUtil {
    @PersistenceContext
    private EntityManager em;

    public JpaUtil() {
    }

    public <T> T findOne(String sql, Map<String, Object> params, Class<T> requiredType) {
        TypedQuery<T> query = this.em.createQuery(sql, requiredType);
        if (params != null) {
            Iterator var5 = params.keySet().iterator();

            while(var5.hasNext()) {
                String key = (String)var5.next();
                query.setParameter(key, params.get(key));
            }
        }

        return query.getSingleResult();
    }

    public <T> List<T> list(String sql, Map<String, Object> params, Class<T> requiredType) {
        Query query = this.em.createQuery(sql);
        if (params != null) {
            Iterator var5 = params.keySet().iterator();

            while(var5.hasNext()) {
                String key = (String)var5.next();
                query.setParameter(key, params.get(key));
            }
        }

        return query.getResultList();
    }

    public <T> Page<T> page(String hsl, Map<String, Object> params, Pageable pageable, Class<T> requiredType) {
        System.out.println(hsl);
        Query query = this.em.createQuery(hsl);
        if (params != null) {
            Iterator var6 = params.keySet().iterator();

            while(var6.hasNext()) {
                String key = (String)var6.next();
                query.setParameter(key, params.get(key));
            }
        }

        if (pageable.isPaged()) {
            query.setFirstResult((int)pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }

        String cHql = QueryUtils.createCountQueryFor(hsl);
        System.out.println("----   " + cHql);
        TypedQuery<Long> cQuery = (TypedQuery)this.em.createQuery(cHql);
        if (params != null) {
            Iterator var8 = params.keySet().iterator();

            while(var8.hasNext()) {
                String key = (String)var8.next();
                cQuery.setParameter(key, params.get(key));
            }
        }

        return PageableExecutionUtils.getPage(query.getResultList(), pageable, () -> {
            return executeCountQuery(cQuery);
        });
    }

    public <T> Page<T> sqlPage(String hsl, String countSql, Map<String, Object> params, Pageable pageable) {
        System.out.println(hsl);
        Query query = this.em.createNativeQuery(hsl);
        if (params != null) {
            Iterator var6 = params.keySet().iterator();

            while(var6.hasNext()) {
                String key = (String)var6.next();
                query.setParameter(key, params.get(key));
            }
        }

        if (pageable.isPaged()) {
            query.setFirstResult((int)pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }

        TypedQuery<BigInteger> cQuery = (TypedQuery)this.em.createNativeQuery(countSql);
        if (params != null) {
            Iterator var10 = params.keySet().iterator();

            while(var10.hasNext()) {
                String key = (String)var10.next();
                cQuery.setParameter(key, params.get(key));
            }
        }

        return PageableExecutionUtils.getPage(query.getResultList(), pageable, () -> {
            return executeIngerCountQuery(cQuery);
        });
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

    private static Long executeIngerCountQuery(TypedQuery<BigInteger> query) {
        Assert.notNull(query, "TypedQuery must not be null!");
        List<BigInteger> totals = query.getResultList();
        Long total = 0L;

        BigInteger element;
        for(Iterator var3 = totals.iterator(); var3.hasNext(); total = total + (element == null ? total : element.longValue())) {
            element = (BigInteger)var3.next();
        }

        return total;
    }
}
