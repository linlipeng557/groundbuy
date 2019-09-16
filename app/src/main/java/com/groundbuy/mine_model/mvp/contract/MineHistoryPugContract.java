package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.HistoryListBean;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineHistoryPugContract {
    interface IView extends MineBaseView {
        void historyListSu(HistoryListBean bean);
    }

    interface  IModel{
        Observable<HttpResult<HistoryListBean>> historyList(String page, String pageSize);
    }
}
