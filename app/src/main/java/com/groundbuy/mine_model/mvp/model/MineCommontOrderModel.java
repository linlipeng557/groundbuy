package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineCommontOrderContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommontOrderModel extends MineBaseModel<MineCommontOrderContract.IView> implements MineCommontOrderContract.IModel{
    public MineCommontOrderModel(MineCommontOrderContract.IView view) {
        super(view);
    }
}
