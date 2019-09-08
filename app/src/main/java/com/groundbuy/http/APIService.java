package com.groundbuy.http;

import com.groundbuy.pojo.UserInfo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
    @GET("/1231" )
    Observable<HttpResult<UserInfo>> login();

}
