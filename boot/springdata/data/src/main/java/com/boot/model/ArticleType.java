package com.boot.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhengxin
 * @date 2021/3/11
 */
@Data
@Entity
@Table(name = "article_type")
public class ArticleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tid;

    private Integer aid;
}
