package com.boot;

import com.boot.dao.ArticleDao;
import com.boot.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengxin
 * @date 2021/3/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JAPTestTwo {

    @Autowired
    ArticleDao articleDao;

    @Test
    public void findContion1() {
        List<Article> articles = articleDao.findContion1("测试标题1");

        System.out.println(articles);
    }

    @Test
    public void findContion2() {
        List<Article> articles1 = articleDao.findContion2("测试标题1");

        System.out.println(articles1);
    }

    @Test
    public void findContion3() {
        List<Article> articles2 = articleDao.findContion3("测试标题1");

        System.out.println(articles2);
    }



    @Test
    public void findContion4() {
        Pageable pageable = PageRequest.of(1, 1);
        List<Article> articles4 = articleDao.findContion4(pageable, "测试标题1");

        System.out.println(articles4);
    }

    @Test
    public void findContion56() {
        List<Article> articles5 = articleDao.findContion5(new ArrayList<>(3));
        List<Article> articles6 = articleDao.findContion6(new ArrayList<>(3));

        System.out.println(articles5);
        System.out.println(articles6);
    }

    @Test
    public void findContion78() {
        Article article = new Article();
        article.setAid(3);
        List<Article> articles7 = articleDao.findContion7(article);
        List<Article> articles8 = articleDao.findContion8(article);

        System.out.println(articles7);
        System.out.println(articles8);
    }

}
