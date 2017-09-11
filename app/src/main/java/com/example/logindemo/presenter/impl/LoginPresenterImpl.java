package com.example.logindemo.presenter.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.logindemo.presenter.LoginPresenter;
import com.example.logindemo.ui.activity.LoginActivity;
import com.example.logindemo.utils.Constants;

/**
 * Created by Administrator on 2017/9/11.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginActivity loginActivity;

    private Handler mHandler;
    private final Context mContext;

    public LoginPresenterImpl(LoginActivity loginActivity) {
        mContext = loginActivity.getApplicationContext();
        this.loginActivity = loginActivity;
    }

    @Override
    public void login(String account, String pwd) {

        if (Constants.isNetAvailable) {
            loginActivity.logining();
            if (account.equals("test") && pwd.equals("123456")) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loginActivity.loginSuccess();
                    }
                },2000);
            } else {
                loginActivity.loginFail();
            }
        } else {
            Toast.makeText(loginActivity, "没有网络", Toast.LENGTH_SHORT).show();
        }
    }
}
