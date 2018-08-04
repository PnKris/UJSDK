package com.ujia.http.callback;

import com.ujia.http.convert.ITransfer;

public abstract class ModelCallback<T> extends StringCallback {

    public ModelCallback(ITransfer transfer) {
        super(transfer);
    }

    @Override
    protected void onConvert(String result) {
        T model = converter.convertModel(result);
        onResult(model);
    }

    protected abstract void onResult(T result);
}
