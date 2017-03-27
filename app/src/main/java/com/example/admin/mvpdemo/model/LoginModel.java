package com.example.admin.mvpdemo.model;

import android.content.Context;

import java.util.Map;

/**
 * Created by admin on 2017/3/27.
 */

public interface LoginModel {
    void login(Context context, Map<String,String> map);
}
