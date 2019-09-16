package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.activity.MineCheckInActivity;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CheckInBean;
import com.groundbuy.mine_model.bean.ConfigBean;
import com.groundbuy.mine_model.mvp.contract.MineCheckInContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCheckInPresenter extends MineBasePrestener<MineCheckInContract.IView, MineCheckInContract.IModel> {
    public MineCheckInPresenter(MineCheckInContract.IView view, MineCheckInContract.IModel model) {
        super(view, model);
    }

    public void singResult() {
        mView.showDialog();
        mModel.singResult().compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<CheckInBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, CheckInBean result, String msg) {
                        mView.dismissDialog();
                        mView.singResultSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void configInfo(String key, int i) {
        if (i == 1) {
            mView.showDialog();
        }
        mModel.configInfo(key).compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<ConfigBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, ConfigBean result, String msg) {
                        mView.configInfoSu(result, i);
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
