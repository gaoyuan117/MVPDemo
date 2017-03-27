package com.example.admin.mvpdemo.model;

import android.content.Context;

import com.example.admin.mvpdemo.bean.LoginBean;
import com.example.admin.mvpdemo.config.HttpResult;
import com.example.admin.mvpdemo.retrofit.RetrofitClient;
import com.example.admin.mvpdemo.rxjava.BaseObserver;
import com.example.admin.mvpdemo.rxjava.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2017/3/27.
 */

public class LoginModelIml implements LoginModel {
    private LoginCallBack loginCallBack;

    public LoginModelIml(LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
    }

    public interface LoginCallBack {
        void success(LoginBean loginBean);
    }

    @Override
    public void login(Context context, Map<String, String> map) {
        RetrofitClient.getInstance().createApi()
                .login(map)
                .compose(RxUtils.<HttpResult<LoginBean>>io_main())
                .subscribe(new BaseObserver<LoginBean>(context) {
                    @Override
                    protected void onHandleSuccess(LoginBean loginBean) {
                        loginCallBack.success(loginBean);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                });
    }
}
