package com.boot.dao;

import com.boot.model.Article;
import com.boot.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author zhengxin
 * @date 2021/3/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TypeDaoTest {



    @Autowired
    ArticleDao articleDao;


    @Autowired
    TypeDao typeDao;


    @Test
    public void test(){

        Article article = new Article();
        article.setCreateTime(new Date());
        article.setAuthor("zhengxin");
        article.setTitle("test1");

        Article article1 = new Article();
        article1.setTitle("test2");
        article1.setAuthor("lisi");
        article1.setCreateTime(new Date());

        Type type = new Type();
        type.setName("11111");

        Type type1 = new Type();
        type1.setName("2222222");

        article.getTypes().add(type);
        article.getTypes().add(type1);
        article1.getTypes().add(type);
        article1.getTypes().add(type1);


        articleDao.save(article);
        articleDao.save(article1);
        typeDao.save(type);
        typeDao.save(type1);

    }
}
