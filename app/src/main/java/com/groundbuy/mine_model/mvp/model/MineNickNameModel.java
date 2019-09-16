package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineNickNameContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineNickNameModel extends MineBaseModel<MineNickNameContract.IView> implements MineNickNameContract.IModel {
    public MineNickNameModel(MineNickNameContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> changeNick(String nick) {
        HashMap<String,String> map = new HashMap<>();
        map.put("nickname",nick);
        return apiService.changeNick(getRequestBody(map));
    }
}
