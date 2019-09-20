package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.bean.RefundListBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/17
 */
public interface OrderTypeContract {
    interface IView extends MineBaseView {
        void getOrderLitstSu(OrderListBean bean);

        void getRundList(RefundListBean bean);

        void cancelOrderSu();

        void deleteOrderSu();

        void confirmReceiptOrderSu();

        void cancelRefundSu();
    }

    interface IModel {
        Observable<HttpResult<OrderListBean>> getOrderLitst(String type, String page, String pageSize);

        Observable<HttpResult<RefundListBean>> getRundList(String page, String pageSize);

        Observable<HttpResult<BaseEntiy>> cancelOrder(String orderNumber);

        Observable<HttpResult<BaseEntiy>> deleteOrder(String orderNumber);

        Observable<HttpResult<BaseEntiy>> confirmReceiptOrder(String orderNumber);

        Observable<HttpResult<BaseEntiy>> cancelRefund(String orderNumber);

    }
}
