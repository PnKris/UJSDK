package com.ujia.http;

import com.ujia.http.builder.GetBuilder;
import com.ujia.http.builder.PostBuilder;
import com.ujia.http.convert.ITransfer;
import com.ujia.http.okhttp.OkHttpStrategy;

public class HttpLoader {
    public HttpLoader loader = new HttpLoader();
    private volatile static IHttpStrategy httpStrategy;
    private static ITransfer transfer;

    public static IHttpStrategy getStrategy() {
        if (httpStrategy == null) {
            synchronized (OkHttpStrategy.class) {
                if (httpStrategy == null) {
                    httpStrategy = new OkHttpStrategy();
                }
            }
        }
        return httpStrategy;
    }

    public static void init(IHttpStrategy strategy, Config config) {
        httpStrategy = strategy;
        httpStrategy.init(config);
    }

    public static void init(Config config) {
        init(getStrategy(), config);
    }

    public static void init() {
        init(new Config());
    }

    public static void init(ITransfer transfer) {
        HttpLoader.transfer = transfer;
        init(new Config());
    }

    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static PostBuilder post() {
        return new PostBuilder();
    }
}
