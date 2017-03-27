package com.example.admin.mvpdemo.rxjava;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.mvpdemo.app.App;
import com.example.admin.mvpdemo.config.HttpResult;

import io.reactivex.Observer;


/**
 * Created by admin on 2017/3/27.
 */

public abstract class BaseObserver<T> implements Observer<HttpResult<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;
    private ProgressDialog progressDialog;

    protected BaseObserver(Context context) {
        this.mContext = context.getApplicationContext();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载中");
    }

    protected BaseObserver() {

    }

    @Override
    public void onNext(HttpResult<T> value) {
        if (value.code == 200) {
            T t = value.data;
            onHandleSuccess(t);
        } else {
            onHandleError(value.code,value.message);
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "error:" + e.toString());
        if(progressDialog!=null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
        if(progressDialog!=null){
            progressDialog.dismiss();
        }
    }

    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(int code,String msg) {
        //根据code处理
        Toast.makeText(App.app, msg, Toast.LENGTH_SHORT).show();
    }

}

