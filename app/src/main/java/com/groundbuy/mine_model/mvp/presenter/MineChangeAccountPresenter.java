package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineChangeAccountContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineChangeAccountPresenter extends MineBasePrestener<MineChangeAccountContract.IView,MineChangeAccountContract.IModel>{
    public MineChangeAccountPresenter(MineChangeAccountContract.IView view, MineChangeAccountContract.IModel model) {
        super(view, model);
    }
}
