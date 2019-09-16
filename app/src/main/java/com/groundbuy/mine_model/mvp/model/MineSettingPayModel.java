package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.mvp.contract.MineSettingPayContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineSettingPayModel extends MineBaseModel<MineSettingPayContract.IView> implements MineSettingPayContract.IModel{
    public MineSettingPayModel(MineSettingPayContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<GetCodeBean>> getChangeOldVerifyCode() {
        return apiService.getChangeOldVerifyCode(getRequestBody());
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> changeLoginPassword(String password, String code, String uuid) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("password",password);
        map.put("code",code);
        map.put("uuid",uuid);
        return apiService.changeLoginPassword(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> setPayPassword(String password, String code, String uuid) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("password",password);
        map.put("code",code);
        map.put("uuid",uuid);
        return apiService.setPayPassword(getRequestBody(map));
    }

}
