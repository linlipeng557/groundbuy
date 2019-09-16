package com.groundbuy.mine_model.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.AvatarBean;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MinePersonalContract;

import java.io.File;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MinePersonalPresenter extends MineBasePrestener<MinePersonalContract.IView, MinePersonalContract.IModel> {
    public MinePersonalPresenter(MinePersonalContract.IView view, MinePersonalContract.IModel model) {
        super(view, model);
    }

    public void changeSex(String sex) {
        mModel.changeSex(sex)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                        mView.showDialog();
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        mView.changeSexSuccess(result);
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        ToastUtils.showShort(msg);
                        mView.dismissDialog();
                    }

                });
    }

    public void updateAvatar(File file) {
        mView.showDialog();
        mModel.updateAvatar(file)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<AvatarBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, AvatarBean result, String msg) {
                        mView.dismissDialog();
                        mView.updateAvatarSuccess(result);
                        ToastUtils.showShort(msg);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }


}
