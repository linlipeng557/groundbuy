package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineOrderDetailsContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineOrderDetailsPresenter extends MineBasePrestener<MineOrderDetailsContract.IView,MineOrderDetailsContract.IModel>{
    public MineOrderDetailsPresenter(MineOrderDetailsContract.IView view, MineOrderDetailsContract.IModel model) {
        super(view, model);
    }
}
