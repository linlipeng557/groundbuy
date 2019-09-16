package com.groundbuy.mine_model.mvp.presenter;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineNickNameContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineNickNamePresenter extends MineBasePrestener<MineNickNameContract.IView,MineNickNameContract.IModel>{
    public MineNickNamePresenter(MineNickNameContract.IView view, MineNickNameContract.IModel model) {
        super(view, model);
    }


    public void changeNick(String nick) {
        mModel.changeNick(nick)
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
                        mView.changeNickSuccess(result,nick);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        ToastUtils.showShort(msg);
                        mView.dismissDialog();
                    }

                });
    }
}
