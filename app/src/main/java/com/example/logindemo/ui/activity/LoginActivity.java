package com.example.logindemo.ui.activity;

import android.content.IntentFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.logindemo.R;
import com.example.logindemo.base.BaseActivity;
import com.example.logindemo.presenter.impl.LoginPresenterImpl;
import com.example.logindemo.receiver.NetChangeReceiver;
import com.example.logindemo.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.et_account)
    EditText et_account; //账号
    @BindView(R.id.et_pwd)
    EditText et_pwd; //密码
    @BindView(R.id.pb)
    ProgressBar pb;

    private LoginPresenterImpl mPresenter;
    private NetChangeReceiver mNetChangeReceiver;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

        mPresenter = new LoginPresenterImpl(this);

        reisgerBroadcast();
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.et_account, R.id.et_pwd};
        return ids;
    }

    @Override
    public void initView() {

    }

    private void reisgerBroadcast() {
        IntentFilter filter = new IntentFilter();
        mNetChangeReceiver = new NetChangeReceiver();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(mNetChangeReceiver,filter);

    }

    @OnClick({R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn: //登录
                String account = et_account.getText().toString().trim();
                String pwd = et_pwd.getText().toString().trim();
                mPresenter.login(account,pwd);
                break;
            default:
                break;
        }

    }

    @Override
    public void logining() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginSuccess() {
        pb.setVisibility(View.GONE);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        pb.setVisibility(View.GONE);
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mNetChangeReceiver!=null) {
            unregisterReceiver(mNetChangeReceiver);
        }
    }
}
