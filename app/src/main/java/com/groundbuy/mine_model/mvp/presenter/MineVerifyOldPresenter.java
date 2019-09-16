package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.HttpResult;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.mvp.contract.MineVerifyOldContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineVerifyOldPresenter extends MineBasePrestener<MineVerifyOldContract.IView, MineVerifyOldContract.IModel> {

    public MineVerifyOldPresenter(MineVerifyOldContract.IView view, MineVerifyOldContract.IModel model) {
        super(view, model);
    }

    public void getVerifyCode( ) {
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

    public void verifyMobile(String code, String uuid) {
        mModel.verifyMobile(code, uuid).delay(2, TimeUnit.SECONDS)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        mView.verifyMobileSuccess();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void changeMobile(String mobile, String code, String uuid) {
        mView.showDialog();
        mModel.changeMobile(mobile, code, uuid)
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
                        mView.changeMobileSuccess();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void   getGeneralCode(String mobile)
    {
        mView.showDialog();
        mModel.getGeneralCode(mobile)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<GetCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccessful(int code, GetCodeBean result, String msg) {
                        mView.getGeneralCodeSuccess(result);
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
