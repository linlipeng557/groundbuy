package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.BaseApplication;
import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.groundbuy.mine_model.bean.CollectShopBean;
import com.groundbuy.mine_model.mvp.contract.ShopOrGoodsContract;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class ShopOrGoodsModel extends MineBaseModel<ShopOrGoodsContract.IView> implements ShopOrGoodsContract.IModel {
    public ShopOrGoodsModel(ShopOrGoodsContract.IView view) {
        super(view);
    }



    @Override
    public Observable<HttpResult<CollectShopBean>> collectShop(String page, String pageSize) {
        HashMap<String,String> map = new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        return apiService.collectShop(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<CollectGoodsBean>> collGoods(String page, String pageSize) {
        HashMap<String,String> map = new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        return apiService.collGoods(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> collect( String type, String action, String array) {
        HashMap<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("action",action);
        map.put("itemId",array);
        return apiService.collect(getRequestBody(map));
    }
}
