package com.springcloud.service.catalog.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="catalog")
public class Catalog implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "catalog_id")
    private long id;

    @Column(nullable = false,length=255,name = "name")
    private String name;

    @Column(nullable = false,name = "parent_id")
    private long parentId;

    @Column(nullable = true,name = "level")
    private Integer level;

    @Column(name = "sort",columnDefinition = "default '0'")
    private Integer sort=0;

    @Column(nullable = true,name = "show_status")
    private boolean showStatus;

    @Column(name = "create_date")
    private Date createDate;

    @Column(length=255,name = "icon")
    private String icon;

}
