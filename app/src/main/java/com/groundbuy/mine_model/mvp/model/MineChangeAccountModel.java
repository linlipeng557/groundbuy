package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineChangeAccountContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineChangeAccountModel extends MineBaseModel<MineChangeAccountContract.IView> implements  MineChangeAccountContract.IModel{
    public MineChangeAccountModel(MineChangeAccountContract.IView view) {
        super(view);
    }
}
