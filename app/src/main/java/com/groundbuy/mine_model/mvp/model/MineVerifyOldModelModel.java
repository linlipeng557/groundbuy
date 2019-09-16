package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.mvp.contract.MineVerifyOldContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineVerifyOldModelModel extends MineBaseModel<MineVerifyOldContract.IView> implements MineVerifyOldContract.IModel {

    public MineVerifyOldModelModel(MineVerifyOldContract.IView view) {
        super(view);
    }


    @Override
    public Observable<HttpResult<GetCodeBean>> getChangeOldVerifyCode() {
        return apiService.getChangeOldVerifyCode(getRequestBody());
    }


    @Override
    public Observable<HttpResult<BaseEntiy>> verifyMobile(String code, String uuid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("uuid", uuid);
        return apiService.verifyMobile(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> changeMobile(String mobile, String code, String uuid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("code", code);
        map.put("uuid", uuid);
        return apiService.changeMobile(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<GetCodeBean>> getGeneralCode(String mobile) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        return apiService.getGeneralCode(getRequestBody(map));
    }
}
