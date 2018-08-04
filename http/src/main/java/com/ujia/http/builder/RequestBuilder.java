package com.ujia.http.builder;

import com.ujia.http.HttpLoader;
import com.ujia.http.callback.ICallback;

import java.util.HashMap;
import java.util.Map;

public abstract class RequestBuilder {
    protected int method = HttpMethod.GET;
    protected String url;
    protected Object tag;
    protected Map<String, Object> params = new HashMap<>();
    protected Map<String, String> headers = new HashMap<>();

    protected ICallback callback;

    public RequestBuilder() {
        method = method();
    }

    public RequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public void param(String key, Object value) {
        if (this.params.containsKey(key)) {
            this.params.remove(key);
        }
        this.params.put(key, value);
    }

    public RequestBuilder tag(Object tag) {
        this.tag = tag;
        return this;
    }

    public RequestBuilder params(Map<String, String> params) {
        if (params == null) {
            throw new NullPointerException("params must is not null");
        }
        if (!params.isEmpty()) {
            this.params.putAll(params);
        }
        return this;
    }

    protected abstract int method();

    public void execute(ICallback callback){
        this.callback = callback;
        HttpLoader.getStrategy().execute(this);
    }

    public int getMethod() {
        return method;
    }

    public Object getTag() {
        return tag;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public ICallback getCallback() {
        return callback;
    }

}
