package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.ExchangeBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineConvertContract {
    interface IView extends MineBaseView {
        void exchangeListSu(ExchangeBean bean);
    }

    interface IModel {
        Observable<HttpResult<ExchangeBean>> exchangeList(String page, String pageSize);
    }
}
