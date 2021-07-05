package com.example.try_68.Net;

import com.example.try_68.utils.GsonUtil;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 一个公共回调
 * @param <T>
 */

public abstract class CommonCallBack<T> extends StringCallback {
    Type mtype;
    public abstract void onSuccess(T response);
    public CommonCallBack(){
        Class<?extends CommonCallBack> clazz = getClass();
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        assert parameterizedType != null;
        mtype = parameterizedType.getActualTypeArguments()[0];

    }
    //错误时回调一个Onerror
    @Override
    public void onError(okhttp3.Call call, Exception e, int id) {
        OnError(e);
    }
    //成功时将将json字符串变成实体类
    @Override
    public void onResponse(String response, int id) {
        try {

            //解析okhttp传来的response
            JSONObject jsr = new JSONObject(response);
            //获取json对象中“resultcode”属性
            int code =jsr.getInt("resultcode");
            if (code == 1){
                //拿到data对象的字符串
                String data = jsr.getString("data");
                //实例化json
                Gson gson = new Gson();
                //用gson将data实例化mtype类
                onSuccess((T) GsonUtil.getGson().fromJson(data,mtype));
            }else {
             OnError(new RuntimeException(jsr.getString("resultmessage")));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public abstract void OnError(Exception e);
    public abstract void Response(T response);

}
