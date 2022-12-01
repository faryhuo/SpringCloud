package com.springcloud.service.catalog.controller;

import com.springcloud.service.catalog.entities.CatalogView;
import com.springcloud.service.catalog.entities.ResponseEntity;
import com.springcloud.service.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/list/tree")
    public ResponseEntity<CatalogView> listAllWithTree(){
        return ResponseEntity.success(catalogService.listAllWithTree());
    }

}

