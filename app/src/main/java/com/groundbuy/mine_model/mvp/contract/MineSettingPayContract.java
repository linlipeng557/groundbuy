package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.GetCodeBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineSettingPayContract {
    interface IView extends MineBaseView {
        void getVerifyCodeSuccess(GetCodeBean bean);
        void  changeLoginPasswordSuccess();
        void  setPayPasswordSu();
    }

    interface IModel {
        Observable<HttpResult<GetCodeBean>> getChangeOldVerifyCode();
        Observable<HttpResult<BaseEntiy>> changeLoginPassword(String password,String code,String uuid);
        Observable<HttpResult<BaseEntiy>> setPayPassword(String password,String code,String uuid);
    }
}
