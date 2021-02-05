package com.boot;

import com.boot.dao.ArticleDao;
import com.boot.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author zhengxin
 * @date 2021/2/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATestOne {

    @Autowired
    private ArticleDao articleDao;


    @Test
    public void save() {
        Article article = new Article();
        article.setAuthor("郑新");
        article.setCreateTime(new Date());
        article.setTitle("测试标题");
        article.setAid(1);
        articleDao.save(article);
    }

    @Test
    public void query() {
        List<Article> list = articleDao.findAll();
        System.out.println(list);
        Optional<Article> article = articleDao.findById(2);
        System.out.println(article.get());
    }

    @Test
    public void update() {
        // aid如果在数据库存在 则是修改, 如果不存在, 则是添加, aid是根据策略来的.
        Article article = new Article();
        article.setAuthor("郑新2");
        article.setCreateTime(new Date());
        article.setTitle("测试标题2");
        article.setAid(2);
        articleDao.save(article);
    }

    @Test
    public void del() {
        articleDao.deleteById(2);
    }


    //查询所有---分页
    @Test
    public void testFindAllWithPage() {
        //从第几页(页数从0开始)开始查,每页多少条
        Pageable pageable = PageRequest.of(2, 1);
        Page<Article> page = articleDao.findAll(pageable);
        for (Article article : page.getContent()) {
            System.out.println(article);
        }
    }

    //查询所有---分页和排序
    @Test
    public void testFindAllWithPageAndSort() {
        Sort sort = Sort.by(Sort.Order.desc("aid"));
        //从第几页(页数从0开始)开始查,每页多少条
        Pageable pageable = PageRequest.of(2, 1, sort);
        Page<Article> page = articleDao.findAll(pageable);
        for (Article article : page.getContent()) {
            System.out.println(article);
        }
    }


}
