package com.boot;

import com.boot.dao.ArticleDao;
import com.boot.model.Article;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengxin
 * @date 2021/3/10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JPATestThree {


    @Autowired
    ArticleDao articleDao;


    @Test
    public void test1() {
        String title = "标题";
        Integer aid = 3;
        List<Article> articles = articleDao.findAll(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(title)) {
                    Predicate predicate = criteriaBuilder.like(root.get("title").as(String.class), "%" + title + "%");
                    predicates.add(predicate);
                }

                if (aid != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("aid").as(Integer.class), aid);
                    predicates.add(predicate);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            }
        });

        System.out.println(articles);
    }


    @Test
    public void test2() {
        String title = "标题";
        Integer aid = null;
        Pageable pageable = PageRequest.of(0,10);
        Page<Article> pages = articleDao.findAll(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(title)) {
                    Predicate predicate = criteriaBuilder.like(root.get("title").as(String.class), "%" + title + "%");
                    predicates.add(predicate);
                }

                if (aid != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("aid").as(Integer.class), aid);
                    predicates.add(predicate);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            }
        },pageable);

        System.out.println("总记录数:" + pages.getTotalElements());
        System.out.println("总页数:" + pages.getTotalPages());
        System.out.println("当前页:" + pages.getNumber());

        System.out.println(pages.getContent());
    }


}
