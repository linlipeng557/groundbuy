package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineAboutContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineAboutModel extends MineBaseModel<MineAboutContract.IView> implements MineAboutContract.IModel{

    public MineAboutModel(MineAboutContract.IView view) {
        super(view);
    }
}
