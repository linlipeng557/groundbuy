package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineWalletContract;
import com.groundbuy.mine_model.mvp.contract.MineWithdrawContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/18
 */
public class MineWithdrawPresenter extends MineBasePrestener<MineWithdrawContract.IView, MineWithdrawContract.IModel> {

    public MineWithdrawPresenter(MineWithdrawContract.IView view, MineWithdrawContract.IModel model) {
        super(view, model);
    }
//提交申请
    public void bindAlipay(String type, String money) {
        mView.withdrawalSu();
        mModel.bindAlipay(type, money)
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
                        mView.withdrawalSu();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
    public void bindWeixin(String type, String money) {
        mView.withdrawalSu();
        mModel.bindWeixin(type, money)
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
                        mView.withdrawalSu();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
