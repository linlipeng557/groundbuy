package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineEditAddressContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineEditAddressPresenter extends MineBasePrestener<MineEditAddressContract.IView,MineEditAddressContract.IModel>{
    public MineEditAddressPresenter(MineEditAddressContract.IView view, MineEditAddressContract.IModel model) {
        super(view, model);
    }
}
