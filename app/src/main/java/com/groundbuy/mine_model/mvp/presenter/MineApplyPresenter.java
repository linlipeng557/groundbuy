package com.groundbuy.mine_model.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineApplyContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineApplyPresenter extends MineBasePrestener<MineApplyContract.IView, MineApplyContract.IModel> {
    public MineApplyPresenter(MineApplyContract.IView view, MineApplyContract.IModel model) {
        super(view, model);
    }

    public void orderRefund(String orderNumber, String remark, String imgs, String amount, String action) {
        mView.showDialog();
        mModel.orderRefund(orderNumber, remark, imgs, amount, action)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        mView.dismissDialog();
                        mView.orderRefund();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        ToastUtils.showShort(msg);
                        mView.dismissDialog();
                    }
                });
    }
}
