package com.ujia.http.okhttp.call;

import com.ujia.http.builder.RequestBuilder;
import com.ujia.http.callback.ICallback;
import com.ujia.http.okhttp.callback.OkCallback;

import okhttp3.Call;
import okhttp3.OkHttpClient;

public abstract class BaseRequest<T extends RequestBuilder> {
    protected OkHttpClient okHttpClient;
    T builder;
    Call call;
    OkCallback okCallback;

    public BaseRequest(OkHttpClient okHttpClient, T builder, OkCallback okCallback) {
        this.okHttpClient = okHttpClient;
        this.builder = builder;
        this.okCallback = okCallback;
        call = build();
    }

    abstract Call build();

    public void execute() {
        final ICallback callback = builder.getCallback();
        callback.onStart();
        call.enqueue(okCallback);
    }

}

