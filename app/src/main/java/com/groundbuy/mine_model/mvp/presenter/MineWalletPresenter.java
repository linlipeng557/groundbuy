package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.BaseApplication;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.RevenueListBean;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.mvp.contract.MineWalletContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineWalletPresenter extends MineBasePrestener<MineWalletContract.IView, MineWalletContract.IModel> {
    public MineWalletPresenter(MineWalletContract.IView view, MineWalletContract.IModel model) {
        super(view, model);
    }

    public void getUserInfo() {

        mModel.getUserInfo().compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, UserBean result, String msg) {
                        BaseApplication.setUserBean(result);
                        mView.getUserInfoSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {

                    }
                });
    }

    public void revenueList(String type, String page, String pagSize) {

        mModel.revenueList(type, page, pagSize)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<RevenueListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, RevenueListBean result, String msg) {
                        mView.revenueListSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
