package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.ExchangeDetailsBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineConvertDetailsContract {
    interface IView extends MineBaseView {
        void exchangeInfoSu(ExchangeDetailsBean bean);
    }

    interface IModel {
        Observable<HttpResult<ExchangeDetailsBean>> exchangeInfo(String exchangeId);
    }
}
