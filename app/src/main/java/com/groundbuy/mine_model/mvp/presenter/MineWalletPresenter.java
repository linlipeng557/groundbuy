package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineWalletContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineWalletPresenter extends MineBasePrestener<MineWalletContract.IView, MineWalletContract.IModel> {
    public MineWalletPresenter(MineWalletContract.IView view, MineWalletContract.IModel model) {
        super(view, model);
    }
}
