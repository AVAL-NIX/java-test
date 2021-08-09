package com.boot.service;

import com.boot.dao.Table;
import com.boot.dao.TableCol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengxin
 * @date 2021/2/3
 */
@Service
public class BaseService {

    @Autowired
    EntityManager entityManager;


    public List<TableCol> findAllColumns(String table) {
        Query query = entityManager.createNativeQuery("" +
                "SELECT " +
                "    COL.COLUMN_NAME,   " +
                "  COL.COLUMN_TYPE,    " +
                "  COL.IS_NULLABLE,   " +
                "  COL.COLUMN_COMMENT " +
                "FROM INFORMATION_SCHEMA.COLUMNS COL " +
                "WHERE  COL.TABLE_NAME='" + table +"' ");
        List<Object[]> list = query.getResultList();
        List<TableCol> tableCols = new ArrayList<>();
        for (Object[] objects : list) {
            TableCol tableCol = new TableCol();
            tableCol.setColName(String.valueOf(objects[0]));
            tableCol.setType(String.valueOf(objects[1]));
            tableCol.setIsNull(String.valueOf(objects[2]));
            tableCol.setComment(String.valueOf(objects[3]));
            tableCols.add(tableCol);
        }
        return tableCols;
    }

    public List<Table> findAllTables() {
        Query query = entityManager.createNativeQuery("" +
                "select table_name ,TABLE_COMMENT " +
                "from information_schema.tables " +
                "where table_schema='aaaa' and table_type='base table' " +
                " ");
        List<Object[]> list = query.getResultList();

        List<Table> tables = new ArrayList<>();
        for (Object[] objects : list) {
            Table table = new Table();
            table.setTableName(String.valueOf(objects[0]));
            table.setComment(String.valueOf(objects[1]));
            tables.add(table);
        }
        return tables;
    }
}
