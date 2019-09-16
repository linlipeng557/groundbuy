package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineRefundContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineRefundPresenter extends MineBasePrestener<MineRefundContract.IView,MineRefundContract.IModel>{
    public MineRefundPresenter(MineRefundContract.IView view, MineRefundContract.IModel model) {
        super(view, model);
    }
}
