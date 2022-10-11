package com.springcloud.service.catalog.service.impl;

import com.springcloud.service.catalog.entities.CatalogView;
import com.springcloud.service.catalog.pojo.Catalog;
import com.springcloud.service.catalog.repository.CatalogRepository;
import com.springcloud.service.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    CatalogRepository catalogRepository;


    @Override
    public List<Catalog> listAll() {
        return catalogRepository.findAll();
    }

    @Override
    public List<CatalogView> listAllWithTree() {
        return listWithTree(0);
    }


    @Override
    public List<CatalogView> listWithTree(int parentId) {
        List<Catalog> catalogs=listAll();
        List<CatalogView> catalogViewList=buildTreeList(catalogs,parentId);
        return catalogViewList;
    }

    private List<CatalogView> buildTreeList(List<Catalog> catalogs,long parentId){
        List<CatalogView> catalogViewList=new ArrayList<>();
        catalogs.forEach((catalog)->{
            if(parentId==catalog.getParentId()){
                CatalogView catalogView=new CatalogView();
                catalogView.setName(catalog.getName());
                catalogView.setLevel(catalog.getLevel());
                catalogView.setShowStatus(catalog.isShowStatus());
                catalogView.setId(catalog.getId());
                catalogView.setParentId(catalog.getParentId());
                catalogView.setSubList(buildTreeList(catalogs,catalog.getId()));
                catalogViewList.add(catalogView);
            }
        });
        return catalogViewList;
    }
}
