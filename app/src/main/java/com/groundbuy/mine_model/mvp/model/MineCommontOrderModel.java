package com.groundbuy.mine_model.mvp.model;

import android.text.TextUtils;
import android.util.Log;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderCommontBean;
import com.groundbuy.mine_model.bean.PictureBean;
import com.groundbuy.mine_model.mvp.contract.MineCommontOrderContract;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommontOrderModel extends MineBaseModel<MineCommontOrderContract.IView> implements MineCommontOrderContract.IModel {
    public MineCommontOrderModel(MineCommontOrderContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<PictureBean>> picture(List<File> files) {

        List<MultipartBody.Part> list = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("image" , file.getName(), requestFile);
            list.add(body);
        }
        return apiService.picture(list);
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> commentGoods(String orderNumber, String content, String imgs, String score) {
        HashMap<String, String> map = new HashMap<>();
        map.put("orderNumber", orderNumber);
        map.put("content", content);
        map.put("score", score);
        if (!TextUtils.isEmpty(imgs)) {
            map.put("imgs", imgs);
        }

        return apiService.commentGoods(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<OrderCommontBean>> commentDetail(String orderNumber) {
        HashMap<String, String> map = new HashMap<>();
        map.put("orderNumber", orderNumber);
        return apiService.commentDetail(getRequestBody(map));
    }
}
