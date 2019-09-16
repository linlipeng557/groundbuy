package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.ExchangeBean;
import com.groundbuy.mine_model.mvp.contract.MineConvertContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineConvertModel extends MineBaseModel<MineConvertContract.IView> implements MineConvertContract.IModel{
    public MineConvertModel(MineConvertContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<ExchangeBean>> exchangeList(String page, String pageSize) {
        HashMap<String,String> map = new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        return apiService.exchangeList(getRequestBody(map));
    }
}
