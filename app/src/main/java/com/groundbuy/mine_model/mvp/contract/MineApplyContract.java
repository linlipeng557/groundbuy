package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineApplyContract {
    interface IView extends MineBaseView {
        void orderRefund();
    }

    interface IModel {
        Observable<HttpResult<BaseEntiy>> orderRefund(String orderNumber, String remark, String imgs, String amount, String action);
    }
}
