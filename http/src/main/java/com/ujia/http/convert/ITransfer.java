package com.ujia.http.convert;

import com.ujia.http.HttpError;

/**
 * 用于实现接口返回值规范化
 */
public abstract class ITransfer {
    HttpError error;
    boolean isSuccess = false;
    String result;
    
    public abstract void convert(String response);

    public boolean isSuccess() {
        return isSuccess;
    }

    public HttpError error() {
        return error;
    }

    public String result() {
        return result;
    }
}
