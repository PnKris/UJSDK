package com.ujia.http.okhttp.call;

import android.text.TextUtils;

import com.ujia.http.builder.GetBuilder;
import com.ujia.http.builder.RequestBuilder;
import com.ujia.http.okhttp.callback.BytesCallback;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GetRequest extends BaseRequest<GetBuilder> {

    public GetRequest(OkHttpClient okHttpClient, GetBuilder builder) {
        super(okHttpClient, builder, new BytesCallback(builder.getCallback()));
    }

    @Override
    Call build() {
        Request.Builder requestBuilder = new Request.Builder();
        if (builder.getHeaders() != null && !builder.getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : builder.getHeaders().entrySet()) {
                requestBuilder.header(entry.getKey(), entry.getValue());
            }
        }

        if (TextUtils.isEmpty(builder.getUrl())) {
            throw new IllegalArgumentException("Url is must not null");
        }

        StringBuilder urlSb = new StringBuilder();
        urlSb.append(builder.getUrl());
        if (!builder.getParams().isEmpty()) {
            if(builder.getUrl().contains("?")) {
                urlSb.append('&');
            }else{
                urlSb.append('?');
            }

            Iterator<Map.Entry<String, Object>> iterator = builder.getParams().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                urlSb.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
            }
            urlSb.deleteCharAt(urlSb.length());
        }

        requestBuilder.url(urlSb.toString());

        if (builder.getTag() == null) {
            builder.tag(this);
        }
        requestBuilder.tag(builder.getTag());
        Request request = requestBuilder.get().build();
        return okHttpClient.newCall(request);
    }


}
