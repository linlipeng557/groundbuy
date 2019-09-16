package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineHelpCenterContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineHelpCenterModel extends MineBaseModel<MineHelpCenterContract.IView> implements MineHelpCenterContract.IModel{
    public MineHelpCenterModel(MineHelpCenterContract.IView view) {
        super(view);
    }
}
