package com.example.admin.mvpdemo.presenter;

import android.content.Context;

import com.example.admin.mvpdemo.bean.CollectBean;
import com.example.admin.mvpdemo.model.CollectModel;
import com.example.admin.mvpdemo.view.CollectView;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/3/27.
 *
 */

public class CollectPresenterIml implements CollectPresenter{
    private CollectModel collectModel;
    private CollectView collectView;

    public CollectPresenterIml(final CollectView collectView) {
        this.collectView = collectView;
        collectModel = new CollectModel(new CollectModel.CollectCallBack() {
            @Override
            public void success(List<CollectBean> collectBean) {
                collectView.collect(collectBean);
            }
        });
    }

    @Override
    public void collect(Context context, Map<String,String> map) {
        collectModel.collect(context,map);
    }
}
