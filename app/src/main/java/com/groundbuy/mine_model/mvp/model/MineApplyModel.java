package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineApplyContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineApplyModel extends MineBaseModel<MineApplyContract.IView> implements MineApplyContract.IModel{
    public MineApplyModel(MineApplyContract.IView view) {
        super(view);
    }
}
