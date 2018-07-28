package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) COMMENT '交易记录ID'")
    private Integer id;
    @Column(columnDefinition = "DATE COMMENT '交易时间'")
    private Date date;
    @Column(columnDefinition = "INT(11) COMMENT '支付方用户名'")
    private Integer payer_id;
    @Column(columnDefinition = "INT(11) COMMENT '收款方用户名'")
    private Integer recipient_id;
    @Column(columnDefinition = "VARCHAR(255) COMMENT '描述'")
    private String description;
    @Column(columnDefinition = "INT(11) COMMENT '交易金额'")
    private int price;

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

    public Integer getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(Integer payer_id) {
        this.payer_id = payer_id;
    }

    public Integer getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(Integer recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
