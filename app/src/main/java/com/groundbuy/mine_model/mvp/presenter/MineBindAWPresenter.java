package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineBindAWContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineBindAWPresenter extends MineBasePrestener<MineBindAWContract.IView,MineBindAWContract.IModel>{
    public MineBindAWPresenter(MineBindAWContract.IView view, MineBindAWContract.IModel model) {
        super(view, model);
    }
}
