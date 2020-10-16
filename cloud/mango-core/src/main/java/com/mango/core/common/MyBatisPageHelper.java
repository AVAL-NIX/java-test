package com.mango.core.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 翻页工具类
 *
 * @author Administrator
 * @date 2020/10/13
 */
public class MyBatisPageHelper {

    public static final String FIND_PAGE = "findPage";

    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, FIND_PAGE);
    }

    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo((List) result));
    }


    public static PageResult getPageResult(PageRequest pageRequest, PageInfo pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageRequest.getPageNum());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalPage(pageInfo.getTotal());
        pageResult.setTotalSize(pageInfo.getSize());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
