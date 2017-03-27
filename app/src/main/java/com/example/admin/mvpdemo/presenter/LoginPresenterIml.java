package com.example.admin.mvpdemo.presenter;

import com.example.admin.mvpdemo.bean.LoginBean;
import com.example.admin.mvpdemo.config.Config;
import com.example.admin.mvpdemo.model.LoginModelIml;
import com.example.admin.mvpdemo.view.LoginView;

/**
 * Created by admin on 2017/3/27.
 *
 */

public class LoginPresenterIml implements LoginPresenter{
    private LoginModelIml loginModelIml;
    private LoginView loginView;

    public LoginPresenterIml(final LoginView loginView) {
        this.loginView = loginView;
        loginModelIml = new LoginModelIml(new LoginModelIml.LoginCallBack() {
            @Override
            public void success(LoginBean loginBean) {
                Config.TOKEN = loginBean.getToken();
                loginView.loginSuccess(loginBean);
            }
        });
    }

    @Override
    public void login() {
        loginModelIml.login(loginView.getContext(),loginView.getParam());
    }

}
