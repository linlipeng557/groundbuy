package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineEditAddressContract;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineEditAddressPresenter extends MineBasePrestener<MineEditAddressContract.IView, MineEditAddressContract.IModel> {
    public MineEditAddressPresenter(MineEditAddressContract.IView view, MineEditAddressContract.IModel model) {
        super(view, model);
    }

    public void addAddress(String name, String mobile, String province, String city, String area, String address, String isChoice) {
        mView.showDialog();
        mModel.addAddress(name, mobile, province, city, area, address, isChoice)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        mView.dismissDialog();
                        mView.addAddressSu();

                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });

    }

    public void editAddress(String name, String mobile, String province, String city, String area, String address, String isChoice, String addressId) {
        mView.showDialog();
        mModel.editAddress(name, mobile, province, city, area, address, isChoice,addressId)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<BaseEntiy>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, BaseEntiy result, String msg) {
                        mView.dismissDialog();
                        mView.editAddressSu();

                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });

    }
}
