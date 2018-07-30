package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) COMMENT '交易记录ID'")
    private Integer id;
    @Column(columnDefinition = "DATE COMMENT '交易时间'")
    private Timestamp timestamp;
    @Column(columnDefinition = "INT(11) COMMENT '支付方ID'")
    private Integer payer_id;
    @Column(columnDefinition = "TINYINT(3) COMMENT '支付方角色'")
    private Integer payer_role;
    @Column(columnDefinition = "TINYINT(3) COMMENT '收款方角色'")
    private Integer recipient_role;
    @Column(columnDefinition = "INT(11) COMMENT '收款方ID'")
    private Integer recipient_id;
    @Column(columnDefinition = "VARCHAR(255) COMMENT '描述'")
    private String description;
    @Column(columnDefinition = "INT(11) COMMENT '交易金额'")
    private Integer price;

    public Transaction(Timestamp timestamp, Integer payer_id, Integer payer_role, Integer recipient_role, Integer recipient_id, String description, Integer price) {
        this.timestamp = timestamp;
        this.payer_id = payer_id;
        this.payer_role = payer_role;
        this.recipient_role = recipient_role;
        this.recipient_id = recipient_id;
        this.description = description;
        this.price = price;
    }

    public Transaction() {
    }

    public Transaction(Integer payer_id, Integer payer_role, Integer recipient_role, Integer recipient_id, String description, int price) {
        this.payer_id = payer_id;
        this.payer_role = payer_role;
        this.recipient_role = recipient_role;
        this.recipient_id = recipient_id;
        this.description = description;
        this.price = price;
        this.timestamp = Timestamp.from(Instant.now());
    }

    public Integer getPayer_role() {
        return payer_role;
    }

    public void setPayer_role(Integer payer_role) {
        this.payer_role = payer_role;
    }

    public Integer getRecipient_role() {
        return recipient_role;
    }

    public void setRecipient_role(Integer recipient_role) {
        this.recipient_role = recipient_role;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
