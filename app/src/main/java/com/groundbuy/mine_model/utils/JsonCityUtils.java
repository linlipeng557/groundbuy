package com.groundbuy.mine_model.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/18
 */
public class JsonCityUtils {
    public static String getJson(Context context) {

//        InputStream input = null;
//        try {
//            //taipingyang.json文件名称
//            input = context.getAssets().open("city.json");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Gson gson = new Gson();
//       // ProCityBean bean = gson.fromJson(convertStreamToString(input), ProCityBean.class);
//        List<ProCityBean> list =gson.fromJson(convertStreamToString(input), new TypeToken<List<ProCityBean>>() {}.getType());
//        return list;

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open("city.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }

    /**
     * input 流转换为字符串
     *
     * @param is
     * @return
     */
    private static String convertStreamToString(InputStream is) {
        String s = null;
        try {
            //格式转换
            Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A");
            if (scanner.hasNext()) {
                s = scanner.next();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


}
