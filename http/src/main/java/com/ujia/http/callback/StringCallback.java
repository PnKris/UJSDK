package com.ujia.http.callback;

import com.ujia.http.HttpError;
import com.ujia.http.convert.Converter;
import com.ujia.http.convert.ITransfer;

import java.nio.charset.Charset;

public abstract class StringCallback implements ICallback {
    ITransfer transfer;
    Converter converter;

    public StringCallback(ITransfer transfer) {
        this.transfer = transfer;
        converter = new Converter();
    }

    public StringCallback() {
        converter = new Converter();
    }


    @Override
    public void onStart() {

    }

    public void onResponse(byte[] bytes, Charset charset) {
        String response = "";
        if (charset != null) {
            response = new String(bytes, charset);
        } else {
            response = new String(bytes);
        }

        if (transfer != null) {
            transfer.convert(response);
            if (transfer.isSuccess()) {
                String result = transfer.result();
                onConvert(result);
            } else {
                HttpError err = transfer.error();
                if (err != null) {
                    onError(err.getCode(), err.getMsg());
                } else {
                    onError(-1, "UnKnow Error");
                }
            }
        } else {
            onResult(response);
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(int code, String msg) {

    }

    protected void onConvert(String result) {
    }

    protected abstract void onResult(String result);


}
