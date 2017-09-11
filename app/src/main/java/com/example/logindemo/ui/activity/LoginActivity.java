package com.example.logindemo.ui.activity;

import android.view.View;
import android.widget.EditText;

import com.example.logindemo.R;
import com.example.logindemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_account)
    EditText et_account; //账号
    @BindView(R.id.et_pwd)
    EditText et_pwd; //密码

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn: //登录

                break;
            default:
                break;
        }

    }
}
