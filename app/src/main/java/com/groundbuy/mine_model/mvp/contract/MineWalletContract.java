package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.RevenueListBean;
import com.groundbuy.mine_model.bean.UserBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineWalletContract {
    interface IView extends MineBaseView {
        void getUserInfoSu(UserBean userBean);

        void revenueListSu(RevenueListBean bean);
    }

    interface IModel {
        Observable<HttpResult<UserBean>> getUserInfo();

        Observable<HttpResult<RevenueListBean>> revenueList(String type, String page, String pagSize);
    }
}
