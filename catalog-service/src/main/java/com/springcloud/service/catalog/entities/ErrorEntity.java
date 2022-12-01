package com.springcloud.service.catalog.entities;

import lombok.Data;

@Data
public class ErrorEntity {
    private int errorCode;
    private String errorMessage;
}
