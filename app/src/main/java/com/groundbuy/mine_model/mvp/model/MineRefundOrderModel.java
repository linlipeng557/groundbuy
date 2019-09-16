package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineRefundOrderContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineRefundOrderModel extends MineBaseModel<MineRefundOrderContract.IView> implements MineRefundOrderContract.IModel{
    public MineRefundOrderModel(MineRefundOrderContract.IView view) {
        super(view);
    }
}
