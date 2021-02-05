package com.boot.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhengxin
 * @date 2021/2/3
 */
@Data
public class Table {

    public String tableName;
    public String comment;
    List<TableCol> cols;
}
