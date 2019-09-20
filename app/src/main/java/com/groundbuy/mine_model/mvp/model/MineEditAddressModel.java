package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.mvp.contract.MineEditAddressContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineEditAddressModel extends MineBaseModel<MineEditAddressContract.IView> implements MineEditAddressContract.IModel {
    public MineEditAddressModel(MineEditAddressContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> addAddress(String name, String mobile, String province, String city, String area, String address, String isChoice) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("mobile", mobile);
        map.put("province", province);
        map.put("city", city);
        map.put("area", area);
        map.put("address", address);
        map.put("isChoice", isChoice);
        return apiService.addAddress(getRequestBody(map));
    }

    @Override
    public Observable<HttpResult<BaseEntiy>> editAddress(String name, String mobile, String province, String city, String area, String address, String isChoice, String addressId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("mobile", mobile);
        map.put("province", province);
        map.put("city", city);
        map.put("area", area);
        map.put("address", address);
        map.put("isChoice", isChoice);
        map.put("addressId", addressId);
        return apiService.editAddress(getRequestBody(map));
    }
}
