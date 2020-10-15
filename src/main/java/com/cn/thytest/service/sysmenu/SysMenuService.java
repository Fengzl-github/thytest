package com.cn.thytest.service.sysmenu;

import com.cn.common.vo.ResResult;
import org.springframework.validation.annotation.Validated;

/**
 * @Author fengzhilong
 * @Date 2020/9/25 18:49
 * @Desc //TODO
 **/
@Validated
public interface SysMenuService {
    ResResult getMenuData();
}
