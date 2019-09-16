package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineOrderListContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineOrderListPresenter extends MineBasePrestener<MineOrderListContract.IView,MineOrderListContract.IModel>{
    public MineOrderListPresenter(MineOrderListContract.IView view, MineOrderListContract.IModel model) {
        super(view, model);
    }
}
