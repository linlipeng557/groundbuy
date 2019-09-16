package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineRefundOrderContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineRefundOrderPresenter extends MineBasePrestener<MineRefundOrderContract.IView,MineRefundOrderContract.IModel>{
    public MineRefundOrderPresenter(MineRefundOrderContract.IView view, MineRefundOrderContract.IModel model) {
        super(view, model);
    }
}
