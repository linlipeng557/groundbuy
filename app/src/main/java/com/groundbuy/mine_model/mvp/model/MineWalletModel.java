package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.RevenueListBean;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.mvp.contract.MineWalletContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineWalletModel extends MineBaseModel<MineWalletContract.IView> implements MineWalletContract.IModel{
    public MineWalletModel(MineWalletContract.IView view) {
        super(view);
    }
    @Override
    public Observable<HttpResult<UserBean>> getUserInfo() {
        return apiService.getUserInfo(getRequestBody());
    }

    @Override
    public Observable<HttpResult<RevenueListBean>> revenueList(String type, String page, String pagSize) {
        HashMap<String,String> map =new HashMap<>();
        map.put("type",type);
        map.put("page",page);
        map.put("pagSize",pagSize);
        return apiService.revenueList(getRequestBody(map));
    }
}
