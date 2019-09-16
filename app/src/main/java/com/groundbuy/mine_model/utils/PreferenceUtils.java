package com.groundbuy.mine_model.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.groundbuy.BaseApplication;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class PreferenceUtils {
    public static final String USER_INFO="USER_INFO";
    public static final String APP_USER_INFO="APP_USER_INFO";
    /**
     * 清除所有数据
     */
    public static void clear() {
        SharedPreferences sharedPreferences = BaseApplication.getAppContext().getSharedPreferences(APP_USER_INFO,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }



    public static void putString(String key, String value) {
        SharedPreferences sp = BaseApplication.getAppContext().getSharedPreferences(APP_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        //editor.commit();
        editor.apply();
    }



    public static String getString(String key, String value) {
        if (BaseApplication.getAppContext() != null) {
            SharedPreferences sp =BaseApplication.getAppContext().getSharedPreferences(APP_USER_INFO, Context.MODE_PRIVATE);
            return sp.getString(key, value);

        }
        return value;
    }

//    public static int getInt(String key, int value) {
//        if (BaseApplication.getAppContext() != null) {
//            SharedPreferences sp = BaseApplication.getAppContext().getSharedPreferences(Constants.APP_USER_INFO, Context.MODE_PRIVATE);
//            return sp.getInt(key, value);
//
//        }
//        return value;
//    }
//
//    public static Boolean getBoolean(String key, Boolean value) {
//        if (BaseApplication.getAppContext() != null) {
//            SharedPreferences sp = BaseApplication.getAppContext().getSharedPreferences(Constants.APP_USER_INFO, Context.MODE_PRIVATE);
//            return sp.getBoolean(key, value);
//
//        }
//        return value;
//    }
//
//    public static Long getLong(String key, Long value) {
//        if (BaseApplication.getAppContext() != null) {
//            SharedPreferences sp = BaseApplication.getAppContext().getSharedPreferences(Constants.APP_USER_INFO, Context.MODE_PRIVATE);
//            return sp.getLong(key, value);
//
//        }
//        return value;
//    }

}
