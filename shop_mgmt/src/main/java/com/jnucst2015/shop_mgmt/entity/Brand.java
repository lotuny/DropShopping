package com.jnucst2015.shop_mgmt.entity;



import javax.persistence.*;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '品牌ID'")
    private Integer id;
    @Column(columnDefinition = "varchar(255) COMMENT '品牌名称'")
    private String name;
    @Column(columnDefinition = "varchar(255) COMMENT '品牌描述'")
    private String description;
    @Column(columnDefinition = "int(11) COMMENT '品牌商ID'")
    private Integer companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer company_id) {
        this.companyId = company_id;
    }
}
