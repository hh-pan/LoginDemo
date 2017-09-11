package com.example.logindemo.presenter;

/**
 * Created by Administrator on 2017/9/11.
 */

public interface LoginPresenter {
    /**
     * 输入账号密码登录
     * @param account
     * @param pwd
     */
    void login(String account, String pwd);
}
