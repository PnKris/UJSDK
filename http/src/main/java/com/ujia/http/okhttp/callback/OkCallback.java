package com.ujia.http.okhttp.callback;

import com.ujia.http.callback.ICallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class OkCallback implements Callback {
    ICallback callback;

    public OkCallback(ICallback callback) {
        this.callback = callback;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        callback.onError(-1, e.getMessage());
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            onResponseSuccess(call, response);
            callback.onComplete();
        } else {
            callback.onError(response.code(), "HTTP REQUEST ERROR");
        }
    }

    public abstract void onResponseSuccess(Call call, Response response);
}
