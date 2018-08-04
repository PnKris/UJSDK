package com.ujia.thread;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.ujia.thread.test", appContext.getPackageName());
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
