package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CheckInBean;
import com.groundbuy.mine_model.bean.ConfigBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineCheckInContract {
    interface IView extends MineBaseView {
        void singResultSu(CheckInBean bean);

        void  checkedInStatus(CheckInBean bean);
        void configInfoSu(ConfigBean bean, int i);
    }

    interface IModel {

        Observable<HttpResult<ConfigBean>> configInfo(String key);

        Observable<HttpResult<CheckInBean>> singResult();
    }
}
