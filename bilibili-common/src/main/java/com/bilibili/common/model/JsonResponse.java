package com.bilibili.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResponse<T> {
    private int statusCode;
    private T data;
    private Error errors;

    public static <T> JsonResponse<T> ok(T data){
        JsonResponse jsonResponse=new JsonResponse(0,data,null);
        return jsonResponse;

    }

    public static JsonResponse fail(String msg){
        Error errors1 =new Error();
        errors1.setErrorCode(-1);
        errors1.setMessage(msg);
        JsonResponse jsonResponse=new JsonResponse(-1,null,errors1);
        return jsonResponse;
    }

}
