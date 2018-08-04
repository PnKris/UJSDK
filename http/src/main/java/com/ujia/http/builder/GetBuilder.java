package com.ujia.http.builder;

public class GetBuilder extends RequestBuilder {

    @Override
    protected int method() {
        return HttpMethod.GET;
    }
}
