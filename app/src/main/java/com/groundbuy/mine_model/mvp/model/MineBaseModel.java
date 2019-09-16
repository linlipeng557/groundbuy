package com.groundbuy.mine_model.mvp.model;

import android.text.TextUtils;

import com.groundbuy.BaseApplication;
import com.groundbuy.http.APIService;
import com.groundbuy.http.RetrofitHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineBaseModel<V> {
    private V view;
    public APIService apiService;

    public MineBaseModel(V view) {
        this.view = view;
        getApi();
    }

    public void getApi() {
        apiService = RetrofitHandler.getApiService();
    }

    public RequestBody getRequestBody(HashMap<String, String> hashMap) {
        StringBuffer data = new StringBuffer();
        if (!TextUtils.isEmpty(BaseApplication.getToken()))
        {
            data.append("?token="+BaseApplication.getToken()+"&");
        }else {
            data.append("?");
        }

        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                data.append(key).append("=").append(val).append("&");
            }
        }
        String jso = data.substring(0, data.length() - 1);
        RequestBody requestBody = RequestBody.create(jso, MediaType.parse("application/json; charset=utf-8"));
        return requestBody;
    }

    public RequestBody getRequestBody() {
        String data = new String();
        if (!TextUtils.isEmpty(BaseApplication.getToken()))
        {
            data= "?token="+BaseApplication.getToken();
        }
        RequestBody requestBody = RequestBody.create(data, MediaType.parse("application/json; charset=utf-8"));
        return requestBody;
    }
}
