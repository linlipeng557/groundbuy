package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/18
 */
public interface MineWithdrawContract {
    interface IView extends MineBaseView {
        void withdrawalSu();
    }

    interface IModel {
        Observable<HttpResult<BaseEntiy>> bindAlipay(String type, String money);

        Observable<HttpResult<BaseEntiy>> bindWeixin(String type, String money);
    }

}
