package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.ExchangeBean;
import com.groundbuy.mine_model.mvp.contract.MineConvertContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineConvertPresenter extends MineBasePrestener<MineConvertContract.IView, MineConvertContract.IModel> {
    public MineConvertPresenter(MineConvertContract.IView view, MineConvertContract.IModel model) {
        super(view, model);
    }

    public void exchangeList(String page, String pageSize) {

        mModel.exchangeList(page, pageSize)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<ExchangeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, ExchangeBean result, String msg) {
                        mView.exchangeListSu(result);
                        mView.dismissDialog();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
