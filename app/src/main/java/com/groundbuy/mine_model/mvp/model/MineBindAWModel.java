package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineBindAWContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineBindAWModel extends MineBaseModel<MineBindAWContract.IView> implements MineBindAWContract.IModel{
    public MineBindAWModel(MineBindAWContract.IView view) {
        super(view);
    }
}
