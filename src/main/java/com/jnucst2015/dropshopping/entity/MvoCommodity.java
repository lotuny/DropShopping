package com.jnucst2015.dropshopping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "MvoCommodity")
public class MvoCommodity
{
    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Column(columnDefinition = "VARCHAR(255) COMMENT '商品名称'")
    private String name;

    @Getter @Setter
    @Column(columnDefinition = "VARCHAR(255) COMMENT '图片路径'")
    private String image;

    @Getter @Setter
    @Column(columnDefinition = "INT(11) COMMENT '分类, 31 - 30 位保留, 29 - 20 位第一级分类, 19 - 10 位第二级分类, 9 - 0 位第三级分类'")
    private Integer classification;

    @Getter @Setter
    @Column(columnDefinition = "VARCHAR(255) COMMENT '描述'")
    private String description;

    @Getter @Setter
    @Column(columnDefinition = "INT(11) COMMENT '所属店铺 ID'")
    private Integer shop_id;

    @Getter @Setter
    @Column(columnDefinition = "INT(11) COMMENT '价格（分）'")
    private Integer price;

    @Getter @Setter
    @Column(columnDefinition = "INT(11) COMMENT '数量'")
    private Integer quantity;

    @Getter @Setter
    @Column(columnDefinition = "TINYINT(4) COMMENT '状态'")
    private Integer state;
}
