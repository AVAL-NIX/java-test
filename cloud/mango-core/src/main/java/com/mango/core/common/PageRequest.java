package com.mango.core.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 *
 * @author Administrator
 * @date 2020/10/13
 */
@Data
public class PageRequest {

    public int pageNum = 1;

    private int pageSize = 10;

    private Map<String , Object> params = new HashMap<>();

    public Object getParam(String key) {
        return getParams().get(key);
    }
}
