package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CheckInBean;
import com.groundbuy.mine_model.bean.ConfigBean;
import com.groundbuy.mine_model.mvp.contract.MineCheckInContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCheckInModel extends MineBaseModel<MineCheckInContract.IView> implements MineCheckInContract.IModel{
    public MineCheckInModel(MineCheckInContract.IView view) {
        super(view);
    }


    @Override
    public Observable<HttpResult<ConfigBean>> configInfo(String key) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("key",key);
        return  apiService.configInfo(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<CheckInBean>> singResult() {
        return apiService.singResult(getRequestBody());
    }
}
