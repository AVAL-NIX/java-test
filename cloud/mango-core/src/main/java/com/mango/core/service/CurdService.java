package com.mango.core.service;

import com.mango.core.common.PageRequest;
import com.mango.core.common.PageResult;

import java.util.List;

/**
 * 通用CURD接口
 *
 * @author zhengxin
 * @date 2020/10/13
 */
public interface CurdService<T> {

    int save(T record);

    int delete(T record);

    int delete(List<T> records);

    T findById(Long id);

    PageResult findPage(PageRequest pageRequest);
}
