package com.ujia.http.okhttp.callback;

import com.ujia.http.callback.ICallback;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Call;
import okhttp3.Response;

public class BytesCallback extends OkCallback {
    public BytesCallback(ICallback callback) {
        super(callback);
    }

    @Override
    public void onResponseSuccess(Call call, Response response) {
        try {
            Charset charset = null;
            byte[] bytes = response.body().bytes();
            if (response.body().contentType() != null
                    && response.body().contentType().charset() != null) {
                charset = response.body().contentType().charset();
            }
            callback.onResponse(bytes, charset);
        } catch (IOException ex) {
            callback.onError(-1, ex.getMessage());
        }
    }
}
