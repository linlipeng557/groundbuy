package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineAddressContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineAddressModel extends MineBaseModel<MineAddressContract.IView> implements MineAddressContract.IModel{
    public MineAddressModel(MineAddressContract.IView view) {
        super(view);
    }
}
