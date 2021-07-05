package com.example.try_68.BIZ;

import android.graphics.Bitmap;

import com.example.try_68.Config.Config;
import com.example.try_68.Msg.UserMsg;
import com.example.try_68.Net.CommonCallBack;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * 注册登陆的业务逻辑
 */
public class UserBiz {
    public void login(String username, String psw, CommonCallBack<UserMsg> commonCallBack) {
        OkHttpUtils
                .post()
                .url(Config.baseURL+"url_login")
                .tag(this)
                .addParams("username",username)
                .addParams("psw",psw)
                .build()
                .execute(commonCallBack);

    }

    public void register(String username, String psw, CommonCallBack<UserMsg> commonCallBack) {
        OkHttpUtils
                .post()
                .url(Config.baseURL+"url_register")
                .tag(this)
                .addParams("username",username)
                .addParams("psw",psw)
                .build()
                .execute(commonCallBack);

    }
}
