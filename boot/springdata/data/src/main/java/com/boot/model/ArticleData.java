package com.boot.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhengxin
 * @date 2021/3/10
 */
@Data
@Entity
@Table(name = "article_data")
public class ArticleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;


    @Column(name = "content2")
    private String content2;

    //建立从文章到文章内容的一对一关系
    // 使用@JoinColumn声明维护外键关系，当前表中的外键articleId指向对方表的主键aid
    @OneToOne
    @JoinColumn(name = "articleId", referencedColumnName = "aid", unique = true)
    private Article article;

}
