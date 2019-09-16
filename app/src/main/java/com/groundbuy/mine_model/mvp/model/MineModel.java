package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.mvp.contract.MineContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public class MineModel extends MineBaseModel<MineContract.IView> implements MineContract.IModel {
    public MineModel(MineContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<UserBean>> getUserInfo() {
        return apiService.getUserInfo(getRequestBody());
    }

    @Override
    public Observable<HttpResult<UserBean>> login() {
        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("mobile", "13794326922");
        loginMap.put("password", "12345678");
        loginMap.put("deviceId", "3");

        return apiService.minelogin(getRequestBody(loginMap));
    }
}
