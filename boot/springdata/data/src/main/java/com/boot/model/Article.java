package com.boot.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    @Column(name = "title")
    private String title;
    private String author;
    private Date createTime;

    @ManyToMany(mappedBy = "articles")
    private List<Type> types = new ArrayList<>();

    @OneToOne(mappedBy = "article",cascade = CascadeType.ALL)
    private ArticleData articleData;


    @OneToMany(mappedBy = "article")
    private List<Comment> comment = new ArrayList<>();
}
