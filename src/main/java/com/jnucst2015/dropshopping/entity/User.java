package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户账号'")
    private String username;

    @Column(columnDefinition = "VARCHAR(40) COMMENT '用户密码'")
    private String password;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户邮件'")
    private String email;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '手机号码'")
    private String telephone;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户生日'")
    private Date birthday;

    @Column(columnDefinition = "VARCHAR(2) COMMENT '性别'")
    private String gender;

    @Column(columnDefinition = "VARCHAR(10) COMMENT '用户角色'")
    private String role;

    @Column(columnDefinition = "INT(11) COMMENT '用户余额'")
    private Integer balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                '}';
    }
}
