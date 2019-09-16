package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineRefundContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineRefundModel extends MineBaseModel<MineRefundContract.IView> implements MineRefundContract.IModel{
    public MineRefundModel(MineRefundContract.IView view) {
        super(view);
    }
}
