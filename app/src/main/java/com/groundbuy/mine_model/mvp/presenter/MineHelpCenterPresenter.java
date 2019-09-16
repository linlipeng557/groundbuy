package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineHelpCenterContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineHelpCenterPresenter extends MineBasePrestener<MineHelpCenterContract.IView,MineHelpCenterContract.IModel>{
    public MineHelpCenterPresenter(MineHelpCenterContract.IView view, MineHelpCenterContract.IModel model) {
        super(view, model);
    }
}
