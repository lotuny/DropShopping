package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;

@Entity @Table(name = "Commodity")
public class Commodity
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(11) COMMENT '商品名称'")
    private String name;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '图片路径'")
    private String image;

    @Column(columnDefinition = "VARCHAR(11) COMMENT '分类'")
    private String classification;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '描述'")
    private String description;

    @Column(columnDefinition = "INT(11) COMMENT '所属店铺 ID'")
    private Integer shop_id;

    @Column(columnDefinition = "INT(11) COMMENT '价格（分）'")
    private Integer price;

    @Column(columnDefinition = "INT(11) COMMENT '数量'")
    private Integer quantity;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getClassification()
    {
        return classification;
    }

    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getShop_id()
    {
        return shop_id;
    }

    public void setShop_id(Integer shop_id)
    {
        this.shop_id = shop_id;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
}
