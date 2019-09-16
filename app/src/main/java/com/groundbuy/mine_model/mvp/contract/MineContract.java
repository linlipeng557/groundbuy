package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.UserBean;

import io.reactivex.Observable;


/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public interface MineContract {
    interface IView extends MineBaseView {
        void  getUserInfo(UserBean bean);
        void  loginSu(UserBean bean);
    }

    interface  IModel{
        Observable<HttpResult<UserBean>> getUserInfo();
        Observable<HttpResult<UserBean>>  login();
    }
}
