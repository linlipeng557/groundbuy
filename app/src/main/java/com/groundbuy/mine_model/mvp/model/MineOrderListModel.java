package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineOrderListContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineOrderListModel extends MineBaseModel<MineOrderListContract.IView> implements MineOrderListContract.IModel{
    public MineOrderListModel(MineOrderListContract.IView view) {
        super(view);
    }
}
