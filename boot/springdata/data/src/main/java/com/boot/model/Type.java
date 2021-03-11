package com.boot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengxin
 * @date 2021/3/11
 */
@Data
@Entity
@Table(name = "type")
public class Type {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @ManyToMany
    @JoinTable(
            //中间表
            name="article_type" ,
            //中间表的外键字段关联当前实体类所对应表的主键字段 joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")},
            // 中间表的外键字段关联对方类所对应表的主键字段 inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")}
            joinColumns = {
                    @JoinColumn(name="tid", referencedColumnName = "id")
            },
            inverseJoinColumns = {@JoinColumn(name="aid",referencedColumnName = "aid")}
    )
    private Set<Article> articles = new HashSet<>();

}
