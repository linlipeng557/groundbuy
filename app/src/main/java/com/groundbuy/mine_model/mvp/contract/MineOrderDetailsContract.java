package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderDetailsBean;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.bean.RefundListBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineOrderDetailsContract {
    interface IView extends MineBaseView {
        void orderDetailSu(OrderDetailsBean bean);


        void cancelOrderSu();

        void deleteOrderSu();

        void confirmReceiptOrderSu();

        void cancelRefundSu();
    }

        interface IModel {
            Observable<HttpResult<OrderDetailsBean>> orderDetail(String orderNumber);



            Observable<HttpResult<BaseEntiy>> cancelOrder(String orderNumber);

            Observable<HttpResult<BaseEntiy>> deleteOrder(String orderNumber);

            Observable<HttpResult<BaseEntiy>> confirmReceiptOrder(String orderNumber);

            Observable<HttpResult<BaseEntiy>> cancelRefund(String orderNumber);

        }
    }
