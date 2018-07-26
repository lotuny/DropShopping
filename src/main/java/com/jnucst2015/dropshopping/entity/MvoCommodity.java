package com.jnucst2015.dropshopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

import javax.persistence.*;
import java.sql.Timestamp;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "MvoCommodity")
public class MvoCommodity
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(columnDefinition = "INT(11) COMMENT '分类'", nullable = false)
    private Integer class_id;

    @Column(columnDefinition = "INT(11) COMMENT '商店 ID'", nullable = false)
    private Integer shop_id;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '名称'", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '图片路径'", nullable = false)
    private String image;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '描述'", nullable = false)
    private String description;

    @Column(columnDefinition = "INT(11) COMMENT '定价（分）'", nullable = false)
    private Integer price;

    @Column(columnDefinition = "INT(11) COMMENT '库存'", nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TINYINT(4) COMMENT '状态'", nullable = false)
    private Integer state;

    @Column(columnDefinition = "TIMESTAMP COMMENT '创建时间'", nullable = false)
    private Timestamp creation_time;

    @Column(columnDefinition = "INT(11) COMMENT '库存预警设置'", nullable = false)
    private Integer warn_num;
}
