package com.example.admin.mvpdemo.presenter;

import android.content.Context;

import com.example.admin.mvpdemo.bean.CategoryBean;
import com.example.admin.mvpdemo.model.CategoryModel;
import com.example.admin.mvpdemo.view.CategoryView;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/3/27.
 */

public class CategoryPresenter {
    private CategoryModel categoryModel;
    private CategoryView categoryView;

    public CategoryPresenter(final CategoryView categoryView) {
        this.categoryView = categoryView;
        categoryModel = new CategoryModel(new CategoryModel.CategoryCallBack() {
            @Override
            public void getCategory(List<CategoryBean> categoryBeen) {
                categoryView.getCategory(categoryBeen);
            }
        });
    }

    public void getCategory(Context context, Map<String,String> map){
        categoryModel.getCategory(context,map);
    }
}
