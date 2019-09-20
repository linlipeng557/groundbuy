package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineEditAddressContract {
    interface IView extends MineBaseView {
        void addAddressSu();
        void editAddressSu();
    }

    interface IModel {
        Observable<HttpResult<BaseEntiy>> addAddress(String name, String mobile, String province, String city, String area, String address, String isChoice);
        Observable<HttpResult<BaseEntiy>> editAddress(String name, String mobile, String province, String city, String area, String address, String isChoice,String addressId);
    }
}
