package com.groundbuy.mine_model.mvp.presenter;

import com.bumptech.glide.Glide;
import com.groundbuy.BaseApplication;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RetrofitHandler;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.mvp.contract.MineContract;
import com.groundbuy.mine_model.utils.GlideUtils;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public class MinePresenter extends MineBasePrestener<MineContract.IView, MineContract.IModel> {
    public MinePresenter(MineContract.IView view, MineContract.IModel model) {
        super(view, model);
    }

    public void login() {

        mModel.login().compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, UserBean result, String msg) {
                        BaseApplication.setToken(result.getToken());
                        mView.loginSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {

                    }
                });

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
                        mView.getUserInfo(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {

                    }
                });
    }
}
