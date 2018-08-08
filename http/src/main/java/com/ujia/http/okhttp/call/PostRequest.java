package com.ujia.http.okhttp.call;

import android.text.TextUtils;

import com.ujia.http.Util;
import com.ujia.http.builder.PostBuilder;
import com.ujia.http.builder.RequestBuilder;
import com.ujia.http.okhttp.callback.BytesCallback;

import java.io.File;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PostRequest extends BaseRequest<PostBuilder> {

    public static final int CONTENT_TYPE_FORM = 1;
    public static final int CONTENT_TYPE_JSON = 2;

    private int contentType = CONTENT_TYPE_FORM;

    public PostRequest(OkHttpClient okHttpClient, PostBuilder builder) {
        super(okHttpClient, builder, new BytesCallback(builder.getCallback()));
    }

    public PostRequest(OkHttpClient okHttpClient, PostBuilder builder, int contentType) {
        super(okHttpClient, builder, new BytesCallback(builder.getCallback()));
        this.contentType = contentType;
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
            throw new NullPointerException("url is null");
        }

        requestBuilder.url(builder.getUrl());
        if (builder.getTag() == null) {
            builder.tag(this);
        }
        requestBuilder.tag(builder.getTag());

        RequestBody requestBody;
        if (builder.getFiles().isEmpty()) {
            requestBody = formBody();
        } else {
            requestBody = multiForm();
        }
        requestBuilder.post(requestBody);

        Request request = requestBuilder.build();
        return okHttpClient.newCall(request);
    }

    private RequestBody formBody() {

        FormBody.Builder bodyBuilder = new FormBody.Builder();

        for (Map.Entry<String, Object> entry : builder.getParams().entrySet()) {
            bodyBuilder.add(entry.getKey(), (String) entry.getValue());
        }

        return bodyBuilder.build();
    }

    private RequestBody multiForm() {
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder();

        for (Map.Entry<String, String> entry : builder.getFiles().entrySet()) {
            File file = new File(entry.getValue());
            String type = Util.judgeType(entry.getValue());
            RequestBody fileBody = RequestBody.create(MediaType.parse(type), file);
            bodyBuilder.addFormDataPart(entry.getKey(), file.getName(), fileBody);
        }

        for (Map.Entry<String, Object> entry : builder.getParams().entrySet()) {
            bodyBuilder.addFormDataPart(entry.getKey(), String.valueOf(entry.getValue()));
        }

        return bodyBuilder.build();
    }

}
