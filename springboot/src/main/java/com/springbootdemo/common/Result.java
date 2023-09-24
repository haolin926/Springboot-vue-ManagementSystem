package com.springbootdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{
    private String code;
    private String msg;
    private T data;

    public static <T> Result<T> success()
    {
        return new <T> Result<T>("1","Success",null);
    }

    public static <T> Result<T> success(String msg, T data)
    {
        return new <T> Result <T>("1",msg,data);
    }
    public static <T> Result<T> success(T data)
    {
        return new <T> Result <T>("1","Success",data);
    }

    public static <T> Result<T> error(String errorCode,String errorMsg)
    {
        return new <T> Result<T>(errorCode,errorMsg,null);
    }
}
