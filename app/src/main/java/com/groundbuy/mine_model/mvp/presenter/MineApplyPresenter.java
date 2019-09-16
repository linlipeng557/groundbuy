package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineApplyContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineApplyPresenter extends MineBasePrestener<MineApplyContract.IView,MineApplyContract.IModel>{
    public MineApplyPresenter(MineApplyContract.IView view, MineApplyContract.IModel model) {
        super(view, model);
    }
}
