package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.mine_model.mvp.contract.MineLogisticsContract;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineLogisticsPresenter extends MineBasePrestener<MineLogisticsContract.IView,MineLogisticsContract.IModel>{
    public MineLogisticsPresenter(MineLogisticsContract.IView view, MineLogisticsContract.IModel model) {
        super(view, model);
    }
}
