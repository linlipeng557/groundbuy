package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineApplyContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineApplyModel extends MineBaseModel<MineApplyContract.IView> implements MineApplyContract.IModel {
    public MineApplyModel(MineApplyContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> orderRefund(String orderNumber, String remark, String imgs, String amount, String action) {
        HashMap<String, String> map = new HashMap<>();
        map.put("orderNumber", orderNumber);
        map.put("remark", remark);
        map.put("imgs", imgs);
        map.put("amount", amount);
        map.put("action", action);
        return apiService.orderRefund(getRequestBody(map));
    }
}
