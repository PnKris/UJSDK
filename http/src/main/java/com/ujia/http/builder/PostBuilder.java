package com.ujia.http.builder;

import java.util.HashMap;
import java.util.Map;

public class PostBuilder extends RequestBuilder {

    protected Map<String, String> files = new HashMap<>();
    protected String json;

    @Override
    protected int method() {
        return HttpMethod.POST;
    }

    public RequestBuilder file(String filePath, String fileName) {
        files.put(fileName, filePath);
        return this;
    }

    public RequestBuilder files(Map<String, String> files) {
        if (files == null) {
            throw new NullPointerException("files must is not null");
        }
        if (!files.isEmpty()) {
            this.files.putAll(files);
        }
        return this;
    }

    public RequestBuilder json(String json) {
        this.json = json;
        return this;
    }

    public Map<String, String> getFiles() {
        return files;
    }

    public String getJson() {
        return json;
    }
}
