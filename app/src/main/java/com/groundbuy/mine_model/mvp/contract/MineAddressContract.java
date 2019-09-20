package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.AddressBean;
import com.groundbuy.mine_model.bean.BaseEntiy;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineAddressContract {
    interface IView extends MineBaseView {
        void addressListSu(AddressBean bean);

        void deleteAddressSu(int position);

        void setDefaultAddress(int position);
    }

    interface IModel {
        Observable<HttpResult<AddressBean>> addressList(String page, String pageSize);

        Observable<HttpResult<BaseEntiy>> deleteAddress(String addressId);

        Observable<HttpResult<BaseEntiy>> setDefaultAddress(String addressId);
    }
}
