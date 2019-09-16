package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.ExchangeDetailsBean;
import com.groundbuy.mine_model.mvp.contract.MineConvertDetailsContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineConvertDetailsPresenter extends MineBasePrestener<MineConvertDetailsContract.IView, MineConvertDetailsContract.IModel> {
    public MineConvertDetailsPresenter(MineConvertDetailsContract.IView view, MineConvertDetailsContract.IModel model) {
        super(view, model);
    }

    public void exchangeInfo(String exchangeId) {
        mView.showDialog();
        mModel.exchangeInfo(exchangeId)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<ExchangeDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, ExchangeDetailsBean result, String msg) {
                        mView.exchangeInfoSu(result);
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
