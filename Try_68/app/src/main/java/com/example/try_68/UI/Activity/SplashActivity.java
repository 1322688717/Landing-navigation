package com.example.try_68.UI.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.try_68.R;

/**
 * 作者：阿宅
 * 时间：6.8
 * 内容：导航页面制作
 */
public class SplashActivity extends AppCompatActivity {
    private Button button;
    //实例化一个Handler
    final Handler handler = new Handler();
    //实例化一个runable
    private Runnable runable = new Runnable() {
        @Override
        public void run() {
            tologin();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //绑定控件
        initview();
        //等待三秒再跳转到登陆Activity
        waittologin();
        //点击按钮后直接跳转到登陆Activity
        clicktologin();

    }

    private void tologin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void clicktologin() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runable);
                tologin();
            }
        });
    }

    private void waittologin() {
        //延迟三秒后实现runable
        handler.postDelayed(runable,3000);
    }

    private void initview() {
        button = findViewById(R.id.id_btn_skip);
    }
}