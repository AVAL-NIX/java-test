package com.boot.dao;

import com.boot.model.Article;
import com.boot.model.ArticleData;
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
public class ArticleDataDaoTest {

    @Autowired
    ArticleDataDao articleDataDao;

    @Autowired
    ArticleDao articleDao;

    @Test
    public void test() {
        Article article = new Article();
        article.setAuthor("张3");
        article.setCreateTime(new Date());
        article.setTitle("title");

        ArticleData articleData = new ArticleData();
        articleData.setContent("1111111");
        articleData.setContent2("222222222");


        articleData.setArticle(article);
        article.setArticleData(articleData);
        articleDao.save(article);
    }

    
}
