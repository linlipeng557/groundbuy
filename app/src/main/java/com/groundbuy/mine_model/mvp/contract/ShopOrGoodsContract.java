package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.groundbuy.mine_model.bean.CollectShopBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public interface ShopOrGoodsContract {
    interface IView extends MineBaseView {
        void collectShopSu(CollectShopBean bean);
        void collGoodsSu(CollectGoodsBean bean);
    }

    interface IModel {
        Observable<HttpResult<CollectShopBean>> collectShop(String page,String pageSize);

        Observable<HttpResult<CollectGoodsBean>> collGoods(String page,String pageSize);
    }

}
