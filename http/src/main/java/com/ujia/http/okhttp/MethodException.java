package com.ujia.http.okhttp;

public class MethodException extends RuntimeException {
    public MethodException() {
        super("Not Found Method");
    }

    public MethodException(int method) {
        super("Not Found Method for" + method);
    }
}
