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
    public Observable<HttpResult<BaseEntiy>> changeInfo(String sexOrAvatar) {
        HashMap<String, String> map = new HashMap<>();
        if ("1".equals(sexOrAvatar)||"0".equals(sexOrAvatar))
        {
            map.put("gender", sexOrAvatar);
        }else {
            map.put("avatar", sexOrAvatar);
        }

        return apiService.changeInfo(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<AvatarBean>> updateAvatar(File file) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        return apiService.updateAvatar(body);
    }


}
