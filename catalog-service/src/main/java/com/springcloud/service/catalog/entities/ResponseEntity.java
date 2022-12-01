package com.springcloud.service.catalog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ResponseEntity<T> {
    private T data;
    private List<ErrorEntity> errors;
    private int statusCode;

    public static ResponseEntity success(Object data){
        return new ResponseEntity(data,null,0);
    }

    public static ResponseEntity error(Object data,List<ErrorEntity> errors,int statusCode){
        return new ResponseEntity(data,errors,statusCode);
    }

    public static ResponseEntity error(List<ErrorEntity> errors,int statusCode){
        return new ResponseEntity(null,errors,statusCode);
    }

    public static ResponseEntity error(ErrorEntity error,int statusCode){
        List<ErrorEntity> errors=new ArrayList<>();
        errors.add(error);
        return new ResponseEntity(null,new ArrayList<>(),statusCode);
    }

    public static ResponseEntity error(String errorMessage){
        ErrorEntity errorEntity=new ErrorEntity();
        errorEntity.setErrorMessage(errorMessage);
        return error(errorEntity,-1);
    }
}
