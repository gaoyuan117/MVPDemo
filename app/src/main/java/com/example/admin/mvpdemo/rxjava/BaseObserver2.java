package com.example.admin.mvpdemo.rxjava;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.mvpdemo.app.App;
import com.example.admin.mvpdemo.config.HttpArray;
import com.example.admin.mvpdemo.config.HttpResult;

import java.util.List;

import io.reactivex.Observer;

/**
 * Created by admin on 2017/3/27.
 */

public abstract class BaseObserver2<T> implements Observer<HttpArray<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;
    private ProgressDialog progressDialog;

    protected BaseObserver2(Context context) {
        this.mContext = context.getApplicationContext();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("正在加载中");
    }

    protected BaseObserver2() {

    }

    @Override
    public void onNext(HttpArray<T> value) {
        if (value.code == 200) {
            List<T> t = value.data;
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

    protected abstract void onHandleSuccess(List<T> list);

    protected void onHandleError(int code,String msg) {
        //根据code处理
        Toast.makeText(App.app, msg, Toast.LENGTH_SHORT).show();
    }

}
