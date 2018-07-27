package com.jnucst2015.dropshopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "MvoCommodity")
public class MvoCommodity
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '商品描述'", nullable = false)
    private String description;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '图片存放路径'", nullable = false)
    private String image;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '商品名称'", nullable = false)
    private String name;

    @Column(columnDefinition = "INT(11) COMMENT '定价（分）'", nullable = false)
    private Integer price;

    @Column(columnDefinition = "INT(11) COMMENT '库存'", nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TINYINT(4) COMMENT '状态'", nullable = false)
    private Integer state;

    @Column(columnDefinition = "INT(11) COMMENT '分类'", nullable = false)
    private Integer class_id;

    @Column(columnDefinition = "TIMESTAMP COMMENT '创建时间'", nullable = false)
    private Timestamp creation_time;

    @Column(columnDefinition = "INT(11) COMMENT '库存预警设置'")
    private Integer warn_num;

    @Column(columnDefinition = "INT(11) COMMENT '品牌 ID'", nullable = false)
    private Integer brand_id;

    @Column(columnDefinition = "INT(11) COMMENT '公司 ID'", nullable = false)
    private Integer company_id;

}
