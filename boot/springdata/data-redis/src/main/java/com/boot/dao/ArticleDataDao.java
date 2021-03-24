package com.boot.dao;

import com.boot.model.Article;
import com.boot.model.ArticleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author zhengxin
 * @date 2021/3/11
 */
@RepositoryRestResource(path = "article-data")
public interface ArticleDataDao extends JpaRepository<ArticleData, Integer>, JpaSpecificationExecutor<ArticleData> {
}
