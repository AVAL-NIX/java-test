package com.boot.dao;

import com.boot.model.ArticleData;
import com.boot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author zhengxin
 * @date 2021/3/11
 */
@RepositoryRestResource(path="comment")
public interface CommentDao extends JpaRepository<Comment,Integer> , JpaSpecificationExecutor<ArticleData> {
}
