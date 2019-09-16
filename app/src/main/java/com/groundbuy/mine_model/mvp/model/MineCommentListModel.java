package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.mine_model.mvp.contract.MineCommentListContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommentListModel extends MineBaseModel<MineCommentListContract.IView> implements MineCommentListContract.IModel{
    public MineCommentListModel(MineCommentListContract.IView view) {
        super(view);
    }
}
