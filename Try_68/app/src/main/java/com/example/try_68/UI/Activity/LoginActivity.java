package com.example.try_68.UI.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.try_68.BIZ.UserBiz;
import com.example.try_68.Msg.UserMsg;
import com.example.try_68.Net.CommonCallBack;
import com.example.try_68.R;
import com.example.try_68.utils.T;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private TextView tv_register;
    private EditText musername;
    private EditText mpsw;
    private UserBiz muserBiz = new UserBiz();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intitview();
        tologinMainpage();
        tologinRegister();
    }

    private void tologinRegister() {
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void tologinMainpage() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = musername.getText().toString();
                String psw = mpsw.getText().toString();
                if (TextUtils.isEmpty(username)||TextUtils.isEmpty(psw)){
                    T.showToast("账号或密码不能为空");
                    return;
                }
                muserBiz.login(username, psw, new CommonCallBack<UserMsg>() {
                    @Override
                    public void onSuccess(UserMsg response) {

                    }

                    @Override
                    public void OnError(Exception e) {

                    }

                    @Override
                    public void Response(UserMsg response) {

                    }
                });
                Intent intent = new Intent(LoginActivity.this,MainPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void intitview() {
        btn_login = findViewById(R.id.id_btn_login);
        tv_register = findViewById(R.id.id_btn_register);
        musername = findViewById(R.id.id_et_username);
        mpsw = findViewById(R.id.id_et_password);
    }
}