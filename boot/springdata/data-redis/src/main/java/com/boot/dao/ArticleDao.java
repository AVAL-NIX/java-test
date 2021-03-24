package com.boot.dao;

import com.boot.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author zhengxin
 * @date 2021/2/3
 */
@RepositoryRestResource(path = "article")
public interface ArticleDao extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {

   //跟据X字段查询
    List<Article> findByTitle(String title);
    // 模糊查询
    List<Article> findByTitleLike(String title);
    // 多个字段模糊查询
    List<Article> findByTitleLikeAndAuthorLike(String title, String author);
    // int 区间查询
    List<Article> findByAidBetween(Integer starAid, Integer endAid);
    // int 小于查询
    List<Article> findByAidLessThan(Integer endAid);
    // int   in 查询
    List<Article> findByAidIn(List<Integer> aids);
    // date > createTime 查询
    List<Article> findByCreateTimeAfter(Date createTime);

    @Query(" from Article a where a.title = ?1 ")
    List<Article> findContion1(String title);

    @Query(" from Article a where a.title = :title ")
    List<Article> findContion2(String title);

    @Query(" from Article a where a.title like %:title% ")
    List<Article> findContion3(String title);

    @Query(" from Article a where a.title like %:title% ")
    List<Article> findContion4(Pageable pageable, String title);

    @Query("from Article a where a.aid in :aids")
    List<Article>  findContion5(@Param("aids") List<String> aids);

    @Query(value = " select * from article a where a.aid in :aids ", nativeQuery = true)
    List<Article>  findContion6(@Param("aids") List<String> aids);

    @Query("from Article a where a.aid = :#{#article.aid} ")
    List<Article>  findContion7(@Param("article") Article article);

    @Query(value = " select * from article a where a.aid = :#{#article.aid} ",nativeQuery = true)
    List<Article>  findContion8(@Param("article") Article article);

}
