package com.ujia.http.callback;

import java.io.File;
import java.nio.charset.Charset;

public abstract class ProcessCallback implements ICallback {
    @Override
    public void onStart() {

    }

    @Override
    public void onResponse(byte[] response, Charset charset) {

    }

    public void onResult(File file) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(int code, String msg) {

    }
}
