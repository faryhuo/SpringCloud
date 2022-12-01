package com.bilibili.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResponse<T> {
    private int statusCode;
    private T data;
    private Errors errors;

    public static <T> JsonResponse<T> ok(T data){
        JsonResponse jsonResponse=new JsonResponse(0,data,null);
        return jsonResponse;

    }

    @Data
    public class Errors{
        private int errorCode;
        private String message;
    }
}
