package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineWalletContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineWalletModel extends MineBaseModel<MineWalletContract.IView> implements MineWalletContract.IModel{
    public MineWalletModel(MineWalletContract.IView view) {
        super(view);
    }
}
