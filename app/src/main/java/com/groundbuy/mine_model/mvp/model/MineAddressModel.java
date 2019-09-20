package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.AddressBean;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineAddressContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineAddressModel extends MineBaseModel<MineAddressContract.IView> implements MineAddressContract.IModel {
    public MineAddressModel(MineAddressContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<AddressBean>> addressList(String page, String pageSize) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page);
        map.put("pageSize", pageSize);
        return apiService.addressList(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> deleteAddress(String addressId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("addressId", addressId);
        return apiService.deleteAddress(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> setDefaultAddress(String addressId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("addressId", addressId);
        return apiService.setDefaultAddress(getRequestBody(map));
    }
}
