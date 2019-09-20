package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.groundbuy.mine_model.bean.CollectShopBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public interface ShopOrGoodsContract {
    interface IView extends MineBaseView {
        void collectShopSu(CollectShopBean bean);
        void collGoodsSu(CollectGoodsBean bean);
        void collectSu();
    }

    interface IModel {
        Observable<HttpResult<CollectShopBean>> collectShop(String page,String pageSize);

        Observable<HttpResult<CollectGoodsBean>> collGoods(String page,String pageSize);

        Observable<HttpResult<BaseEntiy>>  collect(String type, String action, String array);
    }

}
