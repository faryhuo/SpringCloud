package com.springcloud.service.catalog.entities;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class CatalogView {

    private long id;

    private String name;

    private int level;

    private long parentId;

    private boolean showStatus;

    List<CatalogView> subList;
}
