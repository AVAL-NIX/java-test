package com.boot;

import com.boot.dao.Table;
import com.boot.dao.TableCol;
import com.boot.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhengxin
 * @date 2021/2/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATestOne {

    @Autowired
    private BaseService baseService;


    @Test
    public void save() {
        baseService.findAllColumns("t_user");
    }

    @Test
    public void findAllTables() {
       List<Table> tables = baseService.findAllTables();
        for (Table table : tables) {
            List<TableCol> clos = baseService.findAllColumns(table.getTableName());
            table.setCols(clos);
        }
        System.out.println(tables);
    }



}
