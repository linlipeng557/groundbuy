package com.groundbuy;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.groundbuy.http.RetrofitHandler;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.utils.PreferenceUtils;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class BaseApplication extends Application {
    public static Context mContext;
    private static UserBean userBean;
    public static String mToken;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        RetrofitHandler.getInstance();
    }

    public static UserBean getUserBean() {
        if (userBean == null) {
            String userStr = PreferenceUtils.getString(PreferenceUtils.USER_INFO, "");
            if (!TextUtils.isEmpty(userStr)) {
                Gson gson = new Gson();
                userBean = gson.fromJson(userStr, UserBean.class);
            }
        }

        return userBean;
    }

    public static void setUserBean(UserBean bean) {
        userBean = bean;
        if (userBean != null) {
            Gson gson = new Gson();
            PreferenceUtils.putString(PreferenceUtils.USER_INFO, gson.toJson(userBean));
        }
    }

    public static void setToken(String token) {
        mToken = token;
    }

    public static String getToken() {
        return mToken;
    }

    public static Context getAppContext() {
        return mContext;
    }
}
