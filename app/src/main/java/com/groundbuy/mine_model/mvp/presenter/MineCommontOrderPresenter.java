package com.groundbuy.mine_model.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.HttpResult;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderCommontBean;
import com.groundbuy.mine_model.bean.PictureBean;
import com.groundbuy.mine_model.mvp.contract.MineCommontOrderContract;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommontOrderPresenter extends MineBasePrestener<MineCommontOrderContract.IView, MineCommontOrderContract.IModel> {
    public MineCommontOrderPresenter(MineCommontOrderContract.IView view, MineCommontOrderContract.IModel model) {
        super(view, model);
    }

    public void picture(List<File> files) {
        mView.showDialog();
        mModel.picture(files).compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<PictureBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, PictureBean result, String msg) {
                        mView.pictureSu(result);
                        ToastUtils.showShort("AAAAAAAA");

                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        ToastUtils.showShort("SSSSSSS");
                        mView.dismissDialog();
                    }
                });
    }

    public void commentGoods(String orderNumber, String content, String imgs, String score) {
        if (TextUtils.isEmpty(imgs)) {
            mView.showDialog();
        }
        mModel.commentGoods(orderNumber, content, imgs, score)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        mView.commentGoodsSu();
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void commentDetail(String orderNumber) {
        mView.showDialog();
        mModel.commentDetail(orderNumber)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<OrderCommontBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, OrderCommontBean result, String msg) {
                        mView.dismissDialog();
                        mView.commentDetailSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
