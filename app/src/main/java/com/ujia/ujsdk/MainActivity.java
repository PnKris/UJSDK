package com.ujia.ujsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ujia.rxtask.Callback;
import com.ujia.rxtask.RxTask;
import com.ujia.rxtask.Task;
import com.ujia.rxtask.TaskHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    TextView tv_msg;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_msg = findViewById(R.id.tv_msg);
        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
//        TaskHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                testRxTask();
//            }
//        }, 5000);
    }
//
//    public void testRxTask() {
//        Log.d(TAG, "Activiy: threadId=>" + Thread.currentThread().getId());
//
//        RxTask.io(new Task<String>() {
//            @Override
//            public String doBackground() {
//                return "content";
//            }
//        }).call(new Callback<String>() {
//            @Override
//            public void onResult(String s) {
//                Log.d(TAG, "onResult: s=>" + s);
//                tv_msg.setText(s);
//            }
//        });
//
//    }

    public void startTestActivity() {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("Callback", DynamicProxy.newProxy(com.ujia.ujsdk.Callback.class, new com.ujia.ujsdk.Callback() {
            @Override
            public void callback(String msg) {
                Log.d(TAG, "callback: " + msg);
                tv_msg.setText(msg);
            }
        }));

        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        startTestActivity();
    }
}
