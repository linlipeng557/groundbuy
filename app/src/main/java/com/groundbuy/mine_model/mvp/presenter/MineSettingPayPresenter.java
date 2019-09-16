package com.groundbuy.mine_model.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.mvp.contract.MineSettingPayContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineSettingPayPresenter extends MineBasePrestener<MineSettingPayContract.IView, MineSettingPayContract.IModel> {
    public MineSettingPayPresenter(MineSettingPayContract.IView view, MineSettingPayContract.IModel model) {
        super(view, model);
    }

    public void getVerifyCode() {
        mView.showDialog();
        mModel.getChangeOldVerifyCode()
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<GetCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, GetCodeBean result, String msg) {
                        mView.getVerifyCodeSuccess(result);
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void changeLogin(String password, String code, String uuid) {
        mView.showDialog();
        mModel.changeLoginPassword(password, code, uuid)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        ToastUtils.showShort(msg);
                        mView.changeLoginPasswordSuccess();
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void setPayword(String password, String code, String uuid) {
        mView.showDialog();
        mModel.setPayPassword(password, code, uuid)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        ToastUtils.showShort(msg);
                        mView.changeLoginPasswordSuccess();
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
