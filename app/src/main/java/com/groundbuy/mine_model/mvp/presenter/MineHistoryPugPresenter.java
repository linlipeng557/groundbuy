package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.HistoryListBean;
import com.groundbuy.mine_model.mvp.contract.MineHistoryPugContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineHistoryPugPresenter extends MineBasePrestener<MineHistoryPugContract.IView, MineHistoryPugContract.IModel> {
    public MineHistoryPugPresenter(MineHistoryPugContract.IView view, MineHistoryPugContract.IModel model) {
        super(view, model);
    }

    public void historyList(String page, String pageSize) {
        mModel.historyList(page, pageSize)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<HistoryListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, HistoryListBean result, String msg) {
                        mView.dismissDialog();
                        mView.historyListSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
