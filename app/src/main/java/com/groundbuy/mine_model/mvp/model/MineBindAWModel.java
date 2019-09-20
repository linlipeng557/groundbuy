package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineBindAWContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineBindAWModel extends MineBaseModel<MineBindAWContract.IView> implements MineBindAWContract.IModel{
    public MineBindAWModel(MineBindAWContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> bindAlipay(String alipayId, String alipayName) {
        HashMap<String,String> map = new HashMap<>();
        map.put("alipayId",alipayId);
        map.put("alipayName",alipayName);
        return apiService.bindAlipay(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> bindWeixin(String weixinId, String weixinName) {
        HashMap<String,String> map = new HashMap<>();
        map.put("weixinId",weixinId);
        map.put("weixinName",weixinName);
        return apiService.bindAlipay(getRequestBody(map));
    }
}
