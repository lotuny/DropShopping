package com.jnucst2015.dropshopping.vo;

import java.sql.Timestamp;

public class TranVo {

    private Integer id;
    private Timestamp timestamp;
    private String payer;
    private String recipient;
    private String description;
    private double price;

    public TranVo(Integer id, Timestamp timestamp, String payer, String recipient, String description, double price) {
        this.id = id;
        this.timestamp = timestamp;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
