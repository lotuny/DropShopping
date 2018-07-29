package com.jnucst2015.dropshopping_test.vo;

import java.sql.Date;

public class TranVo {

    private Integer id;
    private Date date;
    private String payer;
    private String recipient;
    private String description;
    private int price;

    public TranVo(Integer id, Date date, String payer, String recipient, String description, int price) {
        this.id = id;
        this.date = date;
        this.payer = payer;
        this.recipient = recipient;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
