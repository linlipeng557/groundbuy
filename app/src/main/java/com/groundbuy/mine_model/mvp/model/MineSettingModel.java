package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineSettingContract;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineSettingModel extends MineBaseModel<MineSettingContract.IView> implements MineSettingContract.IModel{
    public MineSettingModel(MineSettingContract.IView view) {
        super(view);
    }


}
