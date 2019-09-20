package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.bean.RefundListBean;
import com.groundbuy.mine_model.mvp.contract.OrderTypeContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/17
 */
public class OrderTypeModel extends MineBaseModel<OrderTypeContract.IView> implements OrderTypeContract.IModel {
    public OrderTypeModel(OrderTypeContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<OrderListBean>> getOrderLitst(String type, String page, String pageSize) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("type",type);
        map.put("page",page);
        map.put("pageSize",pageSize);
        return apiService.getOrderLitst(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<RefundListBean>> getRundList(String page, String pageSize) {
        HashMap<String,String> map  = new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        return apiService.getRundList(getRequestBody(map));

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
