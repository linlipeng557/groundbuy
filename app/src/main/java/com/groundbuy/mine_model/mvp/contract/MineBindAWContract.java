package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineBindAWContract {
    interface IView extends MineBaseView {
        void bindAlipaySu(String alipayId, String alipayName);

        void bindWeixinSu(String weixinId, String weixinName);
    }

    interface IModel {
        Observable<HttpResult<BaseEntiy>> bindAlipay(String alipayId, String alipayName);

        Observable<HttpResult<BaseEntiy>> bindWeixin(String weixinId, String weixinName);
    }
}
