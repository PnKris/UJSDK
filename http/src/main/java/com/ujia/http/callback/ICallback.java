package com.ujia.http.callback;

import java.nio.charset.Charset;

public interface ICallback {
    void onStart();

    void onResponse(byte[] response, Charset charset);

    void onComplete();

    void onError(int code, String msg);
}
