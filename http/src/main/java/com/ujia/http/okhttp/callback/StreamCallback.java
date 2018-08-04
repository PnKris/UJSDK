package com.ujia.http.okhttp.callback;

import com.ujia.http.callback.ICallback;

import okhttp3.Call;
import okhttp3.Response;

public class StreamCallback extends OkCallback {
    public StreamCallback(ICallback callback) {
        super(callback);
    }

    @Override
    public void onResponseSuccess(Call call, Response response) {

    }
}
