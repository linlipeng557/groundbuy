package com.groundbuy.http;


import com.groundbuy.mine_model.bean.AddressBean;
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
import com.groundbuy.mine_model.bean.MyCommentBean;
import com.groundbuy.mine_model.bean.OrderCommontBean;
import com.groundbuy.mine_model.bean.OrderDetailsBean;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.bean.PictureBean;
import com.groundbuy.mine_model.bean.RefundListBean;
import com.groundbuy.mine_model.bean.RevenueListBean;
import com.groundbuy.mine_model.bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
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

    //更改性别 ,昵称， 头像
    @POST("user/updateInfo")
    Observable<HttpResult<BaseEntiy>> changeInfo(@Body RequestBody body);


    //获得用户信息
    @POST("user/info")
    Observable<HttpResult<UserBean>> getUserInfo(@Body RequestBody body);

    //更改头像
    @Multipart
    @POST("upload/avatar")
    Observable<HttpResult<AvatarBean>> updateAvatar(@Part MultipartBody.Part part);

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

    //收藏和取消收藏
    //  @FormUrlEncoded
    @POST("goods/collect")
    Observable<HttpResult<BaseEntiy>> collect(@Body RequestBody body);

    //我的评论
    @POST("user/commentList")
    Observable<HttpResult<MyCommentBean>> getCommentList(@Body RequestBody body);

    //订单列表
    @POST("user/orderList")
    Observable<HttpResult<OrderListBean>> getOrderLitst(@Body RequestBody body);

    //售后列表
    @POST("user/refundList")
    Observable<HttpResult<RefundListBean>> getRundList(@Body RequestBody body);

    //上传图片
    @Multipart
    @POST("upload/picture")
    Observable<HttpResult<PictureBean>> picture(@Part List<MultipartBody.Part> part);

    //评论商品
    @POST("user/commentGoods")
    Observable<HttpResult<BaseEntiy>> commentGoods(@Body RequestBody body);

    //新增地址
    @POST("user/addAddress")
    Observable<HttpResult<BaseEntiy>> addAddress(@Body RequestBody body);

    //获得地址列表
    @POST("user/addressList")
    Observable<HttpResult<AddressBean>> addressList(@Body RequestBody body);

    //删除地址
    @POST("user/deleteAddress")
    Observable<HttpResult<BaseEntiy>> deleteAddress(@Body RequestBody body);

    //设置默认地址
    @POST("user/setDefaultAddress")
    Observable<HttpResult<BaseEntiy>> setDefaultAddress(@Body RequestBody body);

    //编辑地址
    @POST("user/editAddress")
    Observable<HttpResult<BaseEntiy>> editAddress(@Body RequestBody body);

    //绑定支付宝
    @POST("user/bindAlipay")
    Observable<HttpResult<BaseEntiy>> bindAlipay(@Body RequestBody body);

    //绑定微信
    @POST("user/bindWeixin")
    Observable<HttpResult<BaseEntiy>> bindWeixin(@Body RequestBody body);

    //申请提现
    @POST("user/withdrawal")
    Observable<HttpResult<BaseEntiy>> withdrawal(@Body RequestBody body);

    //取消订单
    @POST("user/cancelOrder")
    Observable<HttpResult<BaseEntiy>> cancelOrder(@Body RequestBody body);

    //删除订单
    @POST("user/deleteOrder")
    Observable<HttpResult<BaseEntiy>> deleteOrder(@Body RequestBody body);

    //确认收货
    @POST("user/confirmReceipt")
    Observable<HttpResult<BaseEntiy>> confirmReceiptOrder(@Body RequestBody body);

    //取消售后申请
    @POST("user/cancelRefund")
    Observable<HttpResult<BaseEntiy>> cancelRefund(@Body RequestBody body);

    //订单详情
    @POST("user/orderDetail")
    Observable<HttpResult<OrderDetailsBean>> orderDetail(@Body RequestBody body);

    //评价详情
    @POST("user/commentDetail")
    Observable<HttpResult<OrderCommontBean>> commentDetail(@Body RequestBody body);

    //收入详情列表
    @POST("user/revenueList")
    Observable<HttpResult<RevenueListBean>> revenueList(@Body RequestBody body);

    //申请售后
    @POST("user/orderRefund")
    Observable<HttpResult<BaseEntiy>> orderRefund(@Body RequestBody body);

}
