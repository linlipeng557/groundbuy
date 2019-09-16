package com.groundbuy.http;


import com.groundbuy.mine_model.bean.AvatarBean;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.CheckInBean;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.groundbuy.mine_model.bean.CollectShopBean;
import com.groundbuy.mine_model.bean.ConfigBean;
import com.groundbuy.mine_model.bean.ExchangeBean;
import com.groundbuy.mine_model.bean.ExchangeDetailsBean;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.bean.HistoryListBean;
import com.groundbuy.mine_model.bean.UserBean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {
//    RetrofitHandler.getInstance()
//                         .getApiService()
//                        .login()
//                        .compose(RxTransformerHelper.observableIO2Main(this))
//            .subscribe(new HttpObserver<UserInfo>(this) {
//        @Override
//        public void onSuccessful(int code, UserInfo result, String msg) {
//        }
//
//        @Override
//        public void onFailure(int code, String msg, Throwable e) {
//        }
//    });


    @GET("/1231")
    Observable<HttpResult<String>> login();

    @POST("app/login")
    Observable<HttpResult<UserBean>> minelogin(@Body RequestBody body);

    //更改性别
    @POST("user/updateInfo")
    Observable<HttpResult<BaseEntiy>> changeSex(@Body RequestBody body);

    //更改昵称
    @POST("user/updateInfo")
    Observable<HttpResult<BaseEntiy>> changeNick(@Body RequestBody body);

    //获得用户信息
    @POST("user/info")
    Observable<HttpResult<UserBean>> getUserInfo(@Body RequestBody body);

    //更改头像
    @Multipart
    @POST("upload/avatar")
    Observable<HttpResult<AvatarBean>> updateAvatar(@Part List<MultipartBody.Part> partList);

    //修改手机号码第一次获得验证吗
    @POST("/user/sendCodeByChange")
    Observable<HttpResult<GetCodeBean>> getChangeOldVerifyCode(@Body RequestBody body);

    //普通获得验证码
    @POST("/user/sendCode")
    Observable<HttpResult<GetCodeBean>> getGeneralCode(@Body RequestBody body);

    //验证原手机号
    @POST("user/validMobile")
    Observable<HttpResult<BaseEntiy>> verifyMobile(@Body RequestBody body);

    //修改手机号码
    @POST("user/changeMobile")
    Observable<HttpResult<BaseEntiy>> changeMobile(@Body RequestBody body);

    //修改登录密码
    @POST("user/changePassword")
    Observable<HttpResult<BaseEntiy>> changeLoginPassword(@Body RequestBody body);

    //设置支付密码
    @POST("user/setPayPassword")
    Observable<HttpResult<BaseEntiy>> setPayPassword(@Body RequestBody body);



    //用户签到
    @POST("user/sign")
    Observable<HttpResult<CheckInBean>> singResult(@Body RequestBody body);

    //配置信息内容
    @POST("/app/info")
    Observable<HttpResult<ConfigBean>> configInfo(@Body RequestBody body);

    //兑换列表
    @POST("user/exchangeList")
    Observable<HttpResult<ExchangeBean>> exchangeList(@Body RequestBody body);

    //兑换详情
    @POST("user/exchangeInfo")
    Observable<HttpResult<ExchangeDetailsBean>> exchangeInfo(@Body RequestBody body);

    //历史浏览
    @POST("user/historyList")
    Observable<HttpResult<HistoryListBean>> historyList(@Body RequestBody body);

    //店铺收藏列表
    @POST("user/collectShopList")
    Observable<HttpResult<CollectShopBean>> collectShop(@Body RequestBody body);

    //商品收藏列表
    @POST("user/collectGoodsList")
    Observable<HttpResult<CollectGoodsBean>> collGoods(@Body RequestBody body);

}
