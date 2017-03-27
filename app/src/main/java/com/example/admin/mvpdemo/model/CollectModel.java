package com.example.admin.mvpdemo.model;

import android.content.Context;

import com.example.admin.mvpdemo.bean.CollectBean;
import com.example.admin.mvpdemo.bean.LoginBean;
import com.example.admin.mvpdemo.config.HttpArray;
import com.example.admin.mvpdemo.config.HttpResult;
import com.example.admin.mvpdemo.retrofit.RetrofitClient;
import com.example.admin.mvpdemo.rxjava.BaseObserver;
import com.example.admin.mvpdemo.rxjava.BaseObserver2;
import com.example.admin.mvpdemo.rxjava.RxUtils;

import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2017/3/27.
 */

public class CollectModel {
    private CollectCallBack callBack;

    public CollectModel(CollectCallBack callBack) {
        this.callBack = callBack;
    }

    public interface CollectCallBack {
        void success(List<CollectBean> collectBean);
    }

    public void collect(Context context, Map<String,String> map) {
        RetrofitClient.getInstance().createApi()
                .collect(map)
                .compose(RxUtils.<HttpArray<CollectBean>>io_main())
                .subscribe(new BaseObserver2<CollectBean>() {
                    @Override
                    protected void onHandleSuccess(List<CollectBean> t) {
                        callBack.success(t);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                });
    }

}
