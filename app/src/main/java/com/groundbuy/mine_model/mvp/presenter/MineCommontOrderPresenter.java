package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineCommontOrderContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommontOrderPresenter extends MineBasePrestener<MineCommontOrderContract.IView,MineCommontOrderContract.IModel>{
    public MineCommontOrderPresenter(MineCommontOrderContract.IView view, MineCommontOrderContract.IModel model) {
        super(view, model);
    }
}
