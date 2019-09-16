package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineAddressContract;
import com.groundbuy.mine_model.mvp.model.MineAddressModel;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineAddressPresenter extends MineBasePrestener<MineAddressContract.IView, MineAddressContract.IModel>{
    public MineAddressPresenter(MineAddressContract.IView view, MineAddressContract.IModel model) {
        super(view, model);
    }
}
