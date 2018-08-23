package com.ujia.ujsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ujia.base.BaseActivity;

public class TestActivity extends BaseActivity {
    Callback callback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        callback = (Callback) getIntent().getSerializableExtra("Callback");
    }

    @Override
    protected void onStart() {
        super.onStart();
        callback.callback("我是来自TestActivity的数据");
    }
}
