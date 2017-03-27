package com.example.admin.mvpdemo.view;

import android.content.Context;

import com.example.admin.mvpdemo.bean.LoginBean;

import java.util.Map;

/**
 * Created by admin on 2017/3/27.
 */

public interface LoginView {

    Context getContext();
    Map<String ,String> getParam();
    void loginSuccess(LoginBean loginBean);
}
