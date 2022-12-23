package com.bilibili.common.model;

import lombok.Data;

@Data
public class Error {
    private int errorCode;
    private String message;
}