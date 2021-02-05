package com.boot.model;

import lombok.Data;

/**
 * 表对象
 *
 * @author zhengxin
 * @date 2021/2/3
 */
@Data
public class TableCol {

    /**
     * 列名
     **/
    private String colName;
    /**
     * 类型
     **/
    private String type;
    /**
     * 是否必填
     **/
    private String isNull;
    /**
     * 备注
     **/
    private String comment;


}
