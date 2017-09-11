package com.example.logindemo.view;

/**
 * Created by Administrator on 2017/9/11.
 */

public interface LoginView {
    /**
     * 登录成功
     */
    void loginSuccess();

    /**
     * 登录中
     */
    void logining();

    /**
     * 登录失败
     */
    void loginFail();
}
