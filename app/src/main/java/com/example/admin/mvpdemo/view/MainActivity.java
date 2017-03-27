package com.example.admin.mvpdemo.view;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.mvpdemo.R;
import com.example.admin.mvpdemo.bean.CategoryBean;
import com.example.admin.mvpdemo.bean.CollectBean;
import com.example.admin.mvpdemo.bean.LoginBean;
import com.example.admin.mvpdemo.config.Config;
import com.example.admin.mvpdemo.presenter.CategoryPresenter;
import com.example.admin.mvpdemo.presenter.CollectPresenter;
import com.example.admin.mvpdemo.presenter.CollectPresenterIml;
import com.example.admin.mvpdemo.presenter.LoginPresenterIml;
import com.example.admin.mvpdemo.retrofit.RetrofitClient;
import com.example.admin.mvpdemo.rxjava.RxUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements LoginView, CollectView, CategoryView, View.OnClickListener {
    private Map<String, String> map;
    private Button button, collect, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt_main_login);
        collect = (Button) findViewById(R.id.bt_main_collect);
        category = (Button) findViewById(R.id.bt_main_category);
        category.setOnClickListener(this);
        button.setOnClickListener(this);
        collect.setOnClickListener(this);
        map = new ArrayMap<>();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Map<String, String> getParam() {
        map.put("user", "14763766689");
        map.put("pwd", "123456");
        map.put("driver", "android");
        return map;
    }

    @Override
    public void collect(List<CollectBean> collectBean) {
        Toast.makeText(this, "size " + collectBean.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getToken(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_main_login:
                LoginPresenterIml presenterIml = new LoginPresenterIml(this);
                presenterIml.login();
                break;
            case R.id.bt_main_collect:
                collect();
                break;
            case R.id.bt_main_category:
                category();
                break;
        }
    }

    private void collect() {
        map.put("token", Config.TOKEN);
        CollectPresenter collectPresenter = new CollectPresenterIml(this);
        collectPresenter.collect(this, map);
    }

    @Override
    public void getCategory(List<CategoryBean> list) {
        Toast.makeText(this, "size :" + list.size(), Toast.LENGTH_SHORT).show();
    }

    private void category() {
        map.put("token", Config.TOKEN);
        CategoryPresenter presenter = new CategoryPresenter(this);
        presenter.getCategory(this, map);
    }

}
