package com.jnucst2015.dropshopping.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

    private String username;
    private String password;
    private String email;
    private String telephone;
    //
    public User(){
    }

    public User(User inUser){
        this.username = inUser.getUsername();
        this.password = inUser.getPassword();
        this.email = inUser.getEmail();
        this.telephone = inUser.getTelephone();
    }

    public User(String username, String password, String email, String telephone){
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
