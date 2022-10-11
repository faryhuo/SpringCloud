package com.springcloud.service.catalog.service;

import com.springcloud.service.catalog.entities.CatalogView;
import com.springcloud.service.catalog.pojo.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> listAll();

    List<CatalogView> listAllWithTree();

    List<CatalogView> listWithTree(int parentId);
}
