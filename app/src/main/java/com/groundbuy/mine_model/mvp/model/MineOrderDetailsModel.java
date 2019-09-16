package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineOrderDetailsContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineOrderDetailsModel extends MineBaseModel<MineOrderDetailsContract.IView> implements MineOrderDetailsContract.IModel{
    public MineOrderDetailsModel(MineOrderDetailsContract.IView view) {
        super(view);
    }
}
