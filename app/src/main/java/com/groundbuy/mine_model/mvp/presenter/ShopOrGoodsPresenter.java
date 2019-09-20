package com.groundbuy.mine_model.mvp.presenter;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.groundbuy.mine_model.bean.CollectShopBean;
import com.groundbuy.mine_model.mvp.contract.ShopOrGoodsContract;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class ShopOrGoodsPresenter extends MineBasePrestener<ShopOrGoodsContract.IView, ShopOrGoodsContract.IModel> {

    public ShopOrGoodsPresenter(ShopOrGoodsContract.IView view, ShopOrGoodsContract.IModel model) {
        super(view, model);
    }

    public void collShop(String page, String pageSize) {

        mModel.collectShop(page, pageSize)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<CollectShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, CollectShopBean result, String msg) {
                        mView.collectShopSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void collGoods(String page, String pageSize) {

        mModel.collGoods(page, pageSize)
                .compose(RxTransformerHelper.observableIO2Main(mContext))
                .subscribe(new HttpObserver<CollectGoodsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        addDispose(d);
                    }

                    @Override
                    public void onSuccessful(int code, CollectGoodsBean result, String msg) {
                        mView.collGoodsSu(result);
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }

    public void collect(String type, String action, String array) {
        mView.showDialog();
        mModel.collect(type, action, array)
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
                        mView.collectSu();
                    }

                    @Override
                    public void onFailure(int code, String msg, Throwable e) {
                        mView.dismissDialog();
                    }
                });
    }
}
