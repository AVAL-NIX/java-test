package com.boot;

import com.boot.model.Table;
import com.boot.model.TableCol;
import com.boot.service.BaseService;
import com.boot.util.SpringUtil;
import com.boot.util.WordUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
        BaseService baseService = SpringUtil.getBean(BaseService.class);
        List<Table> tables = baseService.findAllTables();
        for (Table table : tables) {
            List<TableCol> clos = baseService.findAllColumns(table.getTableName());
            table.setCols(clos);
        }
        try {
            WordUtil.createDocContext("d:/test.doc",tables);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
