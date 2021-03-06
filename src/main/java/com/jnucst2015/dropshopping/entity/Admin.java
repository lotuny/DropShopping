package com.jnucst2015.dropshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '管理员账号'")
    private String name;

    @Column(columnDefinition = "VARCHAR(40) COMMENT '管理员密码'")
    private String password;

    public Admin(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
