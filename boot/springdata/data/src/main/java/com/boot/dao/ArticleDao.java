package com.boot.dao;

import com.boot.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author zhengxin
 * @date 2021/2/3
 */
@RepositoryRestResource(path = "article")
public interface ArticleDao extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {


}
