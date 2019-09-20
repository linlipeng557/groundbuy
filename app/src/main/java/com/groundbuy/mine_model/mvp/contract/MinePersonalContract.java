package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.AvatarBean;
import com.groundbuy.mine_model.bean.BaseEntiy;

import java.io.File;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MinePersonalContract {
    interface IView extends MineBaseView {
        void changeSexSuccess(BaseEntiy base);

        void updateAvatarSuccess(AvatarBean bean);

    }

    interface IModel {
        Observable<HttpResult<BaseEntiy>> changeInfo(String sexOrAvatar);



        Observable<HttpResult<AvatarBean>> updateAvatar(File file);

    }
}
