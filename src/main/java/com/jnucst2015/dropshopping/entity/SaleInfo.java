package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;

@Entity
public class SaleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(columnDefinition = "INT(11) COMMENT '商品ID'")
    private Integer mvoCmdtId;

    @Column(columnDefinition = "INT(11) COMMENT '店铺ID'")
    private Integer shopId;

    @Column(columnDefinition = "INT(11) COMMENT '借卖方ID'")
    private Integer sellerId;

    @Column(columnDefinition = "VARCHAR(11) COMMENT '商品名字'")
    private String name;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '商品图片'")
    private String image;

    @Column(columnDefinition = "INT(11) COMMENT '商品价格'")
    private Integer price;

    @Column(columnDefinition = "INT(11) COMMENT '商品数量'")
    private Integer quantity;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '商品描述'")
    private String description;

    @Column(columnDefinition = "TINYINT(2) COMMENT '商品状态'")
    private Integer state;

    @Column(columnDefinition = "INT(11) COMMENT '公司ID'")
    private Integer companyId;

    public SaleInfo(){}

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMvoCmdtId() {
        return mvoCmdtId;
    }

    public void setMvoCmdtId(Integer mvoCmdtId) {
        this.mvoCmdtId = mvoCmdtId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}
