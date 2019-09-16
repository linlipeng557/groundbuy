package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.GetCodeBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;


/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineVerifyOldContract {
    interface IView extends MineBaseView {
        void getVerifyCodeSuccess(GetCodeBean bean);

        void verifyMobileSuccess();

        void changeMobileSuccess();

        void getGeneralCodeSuccess(GetCodeBean bean);
    }

    interface IModel {
        Observable<HttpResult<GetCodeBean>> getChangeOldVerifyCode();

        Observable<HttpResult<BaseEntiy>> verifyMobile(String code, String uuid);

        Observable<HttpResult<BaseEntiy>> changeMobile(String mobile, String code, String uuid);

        Observable<HttpResult<GetCodeBean>> getGeneralCode(String mobile);

    }


}
