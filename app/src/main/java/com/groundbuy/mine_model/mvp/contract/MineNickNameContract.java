package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineNickNameContract {
    interface IView extends MineBaseView {
        void  changeNickSuccess(BaseEntiy base, String name);
    }

    interface  IModel{
        Observable<HttpResult<BaseEntiy>> changeNick(String nick);
    }
}
