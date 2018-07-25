package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order_form")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int(11) COMMENT '借卖方id'")
    private Integer bvo_user_id;
    @Column(columnDefinition = "int(11) COMMENT '消费者id'")
    private Integer consumer_id;
    @Column(columnDefinition = "int(11) COMMENT '商店id'")
    private Integer shop_id;
    @Column(columnDefinition = "int(11) COMMENT '收件人信息id'")
    private Integer receiver_info_id;
    @Column(columnDefinition = "int(11) COMMENT '寄件人信息id'")
    private Integer delivery_info_id;
    @Column(columnDefinition = "timestamp COMMENT '创建时间'")
    private Timestamp Creation_time;
    @Column(columnDefinition = "int(11) COMMENT '总支付费用'")
    private Integer total_bill;
    @Column(columnDefinition = "varchar(255) COMMENT '快递公司'")
    private Integer delivery_comany;
    @Column(columnDefinition = "varchar(255) COMMENT '附加信息'")
    private Integer notes;
    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private Integer state;


}
