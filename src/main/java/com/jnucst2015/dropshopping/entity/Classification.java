package com.jnucst2015.dropshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Classification implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(11) COMMENT '分类id'")
    private Integer id;
    @Column(columnDefinition = "VARCHAR(255) COMMENT '一级分类'")
    private String first_class;
    @Column(columnDefinition = "VARCHAR(255) COMMENT '二级分类'")
    private String second_class;
    @Column(columnDefinition = "VARCHAR(255) COMMENT '三级分类'")
    private String third_class;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_class() {
        return first_class;
    }

    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }

    public String getSecond_class() {
        return second_class;
    }

    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }

    public String getThird_class() {
        return third_class;
    }

    public void setThird_class(String third_class) {
        this.third_class = third_class;
    }
}
