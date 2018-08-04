package com.ujia.http;

import com.ujia.http.builder.GetBuilder;
import com.ujia.http.builder.HttpMethod;
import com.ujia.http.builder.PostBuilder;
import com.ujia.http.builder.RequestBuilder;
import com.ujia.http.okhttp.MethodException;

public abstract class IHttpStrategy {

    public abstract void init(Config config);

    final public void execute(RequestBuilder builder) {
        if (builder == null) {
            throw new NullPointerException("RequestBuilder is null");
        }

        switch (builder.getMethod()) {
            case HttpMethod.DELETE:
                delete(builder);
                break;
            case HttpMethod.GET:
                get((GetBuilder) builder);
                break;
            case HttpMethod.POST:
                post((PostBuilder) builder);
                break;
            case HttpMethod.PUT:
                put(builder);
                break;
            case HttpMethod.OPTIONS:
                options(builder);
                break;

            case HttpMethod.DOWNLOAD:
                download(builder);
                break;
            default:
                throw new MethodException(builder.getMethod());
        }

    }

    public abstract void get(GetBuilder builder);

    public abstract void post(PostBuilder builder);

    public abstract void delete(RequestBuilder builder);

    public abstract void put(RequestBuilder builder);

    public abstract void options(RequestBuilder builder);

    public abstract void download(RequestBuilder builder);
}
