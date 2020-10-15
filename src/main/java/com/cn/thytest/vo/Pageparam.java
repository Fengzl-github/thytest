package com.cn.thytest.vo;

import lombok.Data;

/**
 * @Author fengzhilong
 * @Date 2020/9/27 19:02
 * @Desc //TODO
 **/
@Data
public class Pageparam {
    private Integer pagesize; //每页数
    private Integer currentPage; //当前页
    private Integer total; //总数
}
