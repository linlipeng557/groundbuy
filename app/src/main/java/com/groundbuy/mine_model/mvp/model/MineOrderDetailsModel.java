package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderDetailsBean;
import com.groundbuy.mine_model.bean.RefundListBean;
import com.groundbuy.mine_model.mvp.contract.MineOrderDetailsContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineOrderDetailsModel extends MineBaseModel<MineOrderDetailsContract.IView> implements MineOrderDetailsContract.IModel{
    public MineOrderDetailsModel(MineOrderDetailsContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<OrderDetailsBean>> orderDetail(String orderNumber) {
        HashMap<String,String> map = new HashMap<>();
        map.put("orderNumber",orderNumber);
        return apiService.orderDetail(getRequestBody(map));
    }



    @Override
    public Observable<HttpResult<BaseEntiy>> cancelOrder(String orderNumber) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("orderNumber",orderNumber);
        return apiService.cancelOrder(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> deleteOrder(String orderNumber) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("orderNumber",orderNumber);
        return apiService.deleteOrder(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> confirmReceiptOrder(String orderNumber) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("orderNumber",orderNumber);
        return apiService.confirmReceiptOrder(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> cancelRefund(String orderNumber) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("orderNumber",orderNumber);
        return apiService.cancelRefund(getRequestBody(map));
    }
}
