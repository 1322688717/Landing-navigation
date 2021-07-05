package com.example.try_68.UI.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.try_68.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText username;
    private EditText psw;
    private EditText repsd;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initview();
        setTitle("注册");
    }

    private void initview() {
        username = findViewById(R.id.id_et_username);
        psw = findViewById(R.id.id_et_password);
        repsd = findViewById(R.id.id_et_repassword);
        register = findViewById(R.id.id_btn_register);
    }
}