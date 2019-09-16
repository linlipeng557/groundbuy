package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineCollectContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCollectModel extends MineBaseModel<MineCollectContract.IView> implements MineCollectContract.IModel{
    public MineCollectModel(MineCollectContract.IView view) {
        super(view);
    }
}
