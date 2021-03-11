package com.boot.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhengxin
 * @date 2021/3/10
 */
@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    @ManyToOne
    @JoinColumn(name="articleId" , referencedColumnName = "aid")
    private Article article;
}
