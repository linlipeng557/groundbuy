package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineAboutContract;
import com.groundbuy.mine_model.mvp.model.MineAboutModel;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineAboutPresenter extends MineBasePrestener<MineAboutContract.IView, MineAboutContract.IModel> {
    public MineAboutPresenter(MineAboutContract.IView view, MineAboutContract.IModel model) {
        super(view, model);
    }
}
