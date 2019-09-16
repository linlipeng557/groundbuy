package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineEditAddressContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineEditAddressModel extends MineBaseModel<MineEditAddressContract.IView> implements MineEditAddressContract.IModel{
    public MineEditAddressModel(MineEditAddressContract.IView view) {
        super(view);
    }
}
