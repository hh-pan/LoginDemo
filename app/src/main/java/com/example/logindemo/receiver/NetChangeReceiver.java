package com.example.logindemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.logindemo.utils.Constants;

/**
 * Created by Administrator on 2017/9/11.
 */

public class NetChangeReceiver extends BroadcastReceiver {

    private static final String TAG = "NetChangeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        //todo 监听网络连接的设置，包括wifi和移动数据的打开和关闭
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager manager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.isConnected()) {
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        Log.e(TAG, "当前WiFi连接可用 ");
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        Log.e(TAG, "当前移动网络连接可用 ");
                    }
                    Constants.isNetAvailable = true;
                } else {
                    Log.e(TAG, "当前没有网络连接，请确保你已经打开网络 ");
                    Constants.isNetAvailable = false;
                }
            } else {
                Log.e(TAG, "当前没有网络连接，请确保你已经打开网络 ");
                Constants.isNetAvailable = false;
            }
        }
    }
}
