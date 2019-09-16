package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.ExchangeDetailsBean;
import com.groundbuy.mine_model.mvp.contract.MineConvertDetailsContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineConvertDetailsModel extends MineBaseModel<MineConvertDetailsContract.IView> implements MineConvertDetailsContract.IModel {
    public MineConvertDetailsModel(MineConvertDetailsContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<ExchangeDetailsBean>> exchangeInfo(String exchangeId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("exchangeId", exchangeId);
        return apiService.exchangeInfo(getRequestBody(map));
    }
}
