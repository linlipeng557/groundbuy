package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineWithdrawContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/18
 */
public class MineWithdrawModel extends MineBaseModel<MineWithdrawContract.IView> implements MineWithdrawContract.IModel {

    public MineWithdrawModel(MineWithdrawContract.IView view) {
        super(view);
    }



    @Override
    public Observable<HttpResult<BaseEntiy>> bindAlipay(String type, String money) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("money", money);
        return apiService.bindAlipay(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> bindWeixin(String type, String money) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("money", money);
        return apiService.bindWeixin(getRequestBody(map));
    }
}
