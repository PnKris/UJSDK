package com.ujia.http.callback;

import com.ujia.http.convert.ITransfer;

import java.util.List;

public abstract class ListCallback<T> extends StringCallback {
    public ListCallback(ITransfer transfer) {
        super(transfer);
    }

    @Override
    protected void onConvert(String result) {
        List<T> models = converter.convertList(result);
        onResult(models);
    }


    protected abstract void onResult(List<T> result);
}
