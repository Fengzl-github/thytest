package com.cn.thytest.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @Author fengzhilong
 * @Date 2020/9/28 10:00
 * @Desc //TODO 分页参数
 **/
public class PageUtil {

    public static Pageable getPageable(Integer pageNum, Integer pageSize, String field){

        Sort sort = null;
        // 默认页面为0
        if (pageNum == null || pageNum < 1){
            pageNum = 0;
        }else {
            pageNum -= 1;
        }

        //默认10条
        if (pageSize == null || pageSize < 1){
            pageSize = 10;
        }
        //默认采用id正序排序
        if (field != null){
            sort = Sort.by(Sort.Direction.ASC, field);
        }

        return PageRequest.of(pageNum, pageSize, sort);
    }



    public static Pageable getPageable(Integer pageNum, Integer pageSize){


        return getPageable(pageNum,pageSize, null);
    }

}
