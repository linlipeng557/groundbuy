package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.HistoryListBean;
import com.groundbuy.mine_model.mvp.contract.MineHistoryPugContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineHistoryPugModel extends MineBaseModel<MineHistoryPugContract.IView> implements MineHistoryPugContract.IModel {
    public MineHistoryPugModel(MineHistoryPugContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<HistoryListBean>> historyList(String page, String pageSize) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("pageSize", pageSize);
        return apiService.historyList(getRequestBody(map));
    }
}
