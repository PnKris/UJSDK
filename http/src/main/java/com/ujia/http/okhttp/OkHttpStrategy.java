package com.ujia.http.okhttp;

import com.ujia.http.Config;
import com.ujia.http.IHttpStrategy;
import com.ujia.http.builder.GetBuilder;
import com.ujia.http.builder.PostBuilder;
import com.ujia.http.builder.RequestBuilder;
import com.ujia.http.okhttp.call.GetRequest;
import com.ujia.http.okhttp.call.PostRequest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkHttpStrategy extends IHttpStrategy {

    OkHttpClient okHttpClient;

    @Override
    public void init(Config config) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .readTimeout(config.readTimeout, TimeUnit.SECONDS)
                .writeTimeout(config.writeTimeout, TimeUnit.SECONDS)
                .connectTimeout(config.connTimeout, TimeUnit.SECONDS);

        okHttpClient = okHttpBuilder.build();

    }

    @Override
    public void get(GetBuilder builder) {
        GetRequest request = new GetRequest(okHttpClient, builder);
        request.execute();
    }

    @Override
    public void post(PostBuilder builder) {
        PostRequest request = new PostRequest(okHttpClient, builder);
        request.execute();
    }

    @Override
    public void delete(RequestBuilder builder) {

    }

    @Override
    public void put(RequestBuilder builder) {

    }

    @Override
    public void options(RequestBuilder builder) {

    }

    @Override
    public void download(RequestBuilder builder) {

    }
}
