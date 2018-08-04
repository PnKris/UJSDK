package com.ujia.thread;

import org.junit.Test;

public class RxThreadTest {
    private static final String TAG = "RxThreadTest";

    @Test
    public void postOnMain() {
        RxThread rxThread = new RxThread();
        rxThread.postOnMain(new Task<String>() {
            @Override
            public String doBackground() {
                System.out.println("doBackground: threadId=>" + Thread.currentThread().getId());
                return "222";
            }
        }, new Callback<String>() {
            @Override
            public void onResult(String s) {
                System.out.println("onResult: threadId=>" + Thread.currentThread().getId());

//                Log.d(TAG, "onResult: threadId=>" + Thread.currentThread().getId());
                System.out.println("onResult: s=>" + s);
            }
        });
    }
}