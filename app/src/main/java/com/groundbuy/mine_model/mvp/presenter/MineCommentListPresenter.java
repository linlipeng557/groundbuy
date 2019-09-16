package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineCommentListContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommentListPresenter extends MineBasePrestener<MineCommentListContract.IView,MineCommentListContract.IModel>{
    public MineCommentListPresenter(MineCommentListContract.IView view, MineCommentListContract.IModel model) {
        super(view, model);
    }
}
