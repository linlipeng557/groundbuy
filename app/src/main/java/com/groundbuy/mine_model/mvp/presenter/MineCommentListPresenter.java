package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.MyCommentBean;
import com.groundbuy.mine_model.mvp.contract.MineCommentListContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommentListPresenter extends MineBasePrestener<MineCommentListContract.IView, MineCommentListContract.IModel> {
    public MineCommentListPresenter(MineCommentListContract.IView view, MineCommentListContract.IModel model) {
        super(view, model);
    }

    public void getCommentList(String page, String pageSize) {
        mModel.getCommentList(page, pageSize)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<MyCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, MyCommentBean result, String msg) {
                        mView.getCommentListSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
