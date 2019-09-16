package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineSettingContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineSettingPresenter extends MineBasePrestener<MineSettingContract.IView,MineSettingContract.IModel>{
    public MineSettingPresenter(MineSettingContract.IView view, MineSettingContract.IModel model) {
        super(view, model);
    }
}
