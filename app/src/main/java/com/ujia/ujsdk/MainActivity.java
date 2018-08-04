package com.ujia.ujsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ujia.rxtask.Callback;
import com.ujia.rxtask.MainHandlerUtil;
import com.ujia.rxtask.RxTask;
import com.ujia.rxtask.Task;
import com.ujia.utils.DisplayUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_msg = findViewById(R.id.tv_msg);
        
    }


    @Override
    protected void onResume() {
        super.onResume();
        MainHandlerUtil.postDelayed(new Runnable() {
            @Override
            public void run() {
                testRxTask();
            }
        }, 5000);
    }

    public void testRxTask() {
        Log.d(TAG, "Activiy: threadId=>" + Thread.currentThread().getId());

        RxTask.io(new Task<String>() {
            @Override
            public String doBackground() {
                return "content";
            }
        }).call(new Callback<String>() {
            @Override
            public void onResult(String s) {
                Log.d(TAG, "onResult: s=>" + s);
                tv_msg.setText(s);
            }
        });

    }


}
