package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineLogisticsContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineLogisticsModel extends MineBaseModel<MineLogisticsContract.IView> implements MineLogisticsContract.IModel{
    public MineLogisticsModel(MineLogisticsContract.IView view) {
        super(view);
    }
}
