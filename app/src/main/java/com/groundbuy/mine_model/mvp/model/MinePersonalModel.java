package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.AvatarBean;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MinePersonalContract;

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
public class MinePersonalModel extends MineBaseModel<MinePersonalContract.IView> implements MinePersonalContract.IModel {
    public MinePersonalModel(MinePersonalContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> changeSex(String sex) {
        HashMap<String,String> map = new HashMap<>();
        map.put("gender",sex);
        return apiService.changeSex(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<AvatarBean>> updateAvatar(File file) {
        RequestBody photoRequestBody = RequestBody.create( file,MediaType.parse("image/jpg"));
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), photoRequestBody);
        List<MultipartBody.Part> list = new ArrayList<>();
        list.add(body);
        return apiService.updateAvatar(list);
    }


}
