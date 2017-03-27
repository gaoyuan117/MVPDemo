package com.example.admin.mvpdemo.model;

import android.content.Context;

import com.example.admin.mvpdemo.bean.CategoryBean;
import com.example.admin.mvpdemo.config.HttpArray;
import com.example.admin.mvpdemo.retrofit.RetrofitClient;
import com.example.admin.mvpdemo.rxjava.BaseObserver2;
import com.example.admin.mvpdemo.rxjava.RxUtils;

import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2017/3/27.
 */

public class CategoryModel {
    private CategoryCallBack categoryCallBack;
    public interface CategoryCallBack{
        void getCategory(List<CategoryBean> categoryBeen);
    }

    public CategoryModel(CategoryCallBack categoryCallBack) {
        this.categoryCallBack = categoryCallBack;
    }

    public void getCategory(Context context, Map<String,String> map){
        RetrofitClient.getInstance().createApi()
                .category(map)
                .compose(RxUtils.<HttpArray<CategoryBean>>io_main())
                .subscribe(new BaseObserver2<CategoryBean>() {
                    @Override
                    protected void onHandleSuccess(List<CategoryBean> t) {
                        categoryCallBack.getCategory(t);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                });
    }
}
