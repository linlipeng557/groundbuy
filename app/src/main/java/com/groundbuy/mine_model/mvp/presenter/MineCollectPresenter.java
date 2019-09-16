package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineCollectContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCollectPresenter extends MineBasePrestener<MineCollectContract.IView,MineCollectContract.IModel>{
    public MineCollectPresenter(MineCollectContract.IView view, MineCollectContract.IModel model) {
        super(view, model);
    }
}
