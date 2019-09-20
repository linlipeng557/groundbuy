package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.OrderCommontBean;
import com.groundbuy.mine_model.bean.PictureBean;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineCommontOrderContract {
    interface IView extends MineBaseView {
        void pictureSu(PictureBean bean);

        void commentGoodsSu();

        void commentDetailSu(OrderCommontBean bean);
    }


    interface IModel {
        Observable<HttpResult<PictureBean>> picture(List<File> files);

        Observable<HttpResult<BaseEntiy>> commentGoods(String orderNumber, String content, String imgs, String score);

        Observable<HttpResult<OrderCommontBean>> commentDetail(String orderNumber);
    }
}
