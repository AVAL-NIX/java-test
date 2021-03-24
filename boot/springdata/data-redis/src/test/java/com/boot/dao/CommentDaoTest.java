package com.boot.dao;

import com.boot.dao.ArticleDao;
import com.boot.model.Article;
import com.boot.model.Comment;
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
public class CommentDaoTest {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    CommentDao commentDao;

    @Test
    public void save(){
        Article article = new Article();
        article.setTitle("标秒1");
        article.setAuthor("黑马");
        article.setCreateTime(new Date());

        Comment comment = new Comment();
        comment.setComment("1111");

        Comment comment1 = new Comment();
        comment1.setComment("22222");

        comment.setArticle(article);
        comment1.setArticle(article);

        article.getComment().add(comment);
        article.getComment().add(comment1);

        articleDao.save(article);
        commentDao.save(comment);
        commentDao.save(comment1);
    }

}
