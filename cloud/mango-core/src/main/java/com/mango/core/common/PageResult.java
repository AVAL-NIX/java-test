package com.mango.core.common;


import lombok.Data;

import java.util.List;


/**
 * 分页返回对象
 *
 * @author Administrator
 * @date 2020/10/13
 */
@Data
public class PageResult {

    private int pageNum;

    private int pageSize;

    private int totalSize;

    private long totalPage;

    private List content;

}
