package com.groundbuy.http;

import android.util.Log;

import com.groundbuy.BaseApplication;
import com.groundbuy.http.fastjsonConverter.FastJsonConverterFactory;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitHandler {
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private static RetrofitHandler retrofitHandler;
    private static APIService apiService;

  //  private static final String BASE_URL = "http://192.168.2.113:8899";
    public static final String BASE_URL = "http://tuangou.leaf-tech.net:8081/";
    private static final int HTTP_TIME_OUT_TIME = 30;
    private static final boolean IS_DEBUG = true;
    private RetrofitHandler() {
        initRetrofit();
    }

    public static synchronized RetrofitHandler getInstance() {
        if (retrofitHandler == null) {
            synchronized (RetrofitHandler.class) {
                if (retrofitHandler == null) {
                    retrofitHandler = new RetrofitHandler();
                }
            }
        }
        return retrofitHandler;
    }

    /**
     * 获取 Retrofit
     */
    private void initRetrofit() {
        initOkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        apiService = retrofit.create(APIService.class);
    }

    /**
     * 单例模式获取 OkHttpClient
     */
    private static void initOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (RetrofitHandler.class) {
                if (okHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(HTTP_TIME_OUT_TIME, TimeUnit.SECONDS)
                            .readTimeout(HTTP_TIME_OUT_TIME, TimeUnit.SECONDS)
                            .writeTimeout(HTTP_TIME_OUT_TIME, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(false)
                            .addInterceptor(getHeaderInterceptor());
                    if (IS_DEBUG)
                        builder.addInterceptor(getLogInterceptor());
                    okHttpClient = builder.build();
                }
            }
        }
    }

    //日志拦截器
    private static Interceptor getLogInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.w("RetrofitHandler", message);
            }
        });
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
        return httpLoggingInterceptor;
    }

    //请求头拦截器
    private static Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {

                Request originalRequest = chain.request();

                if (null == originalRequest.body()) {
                    return chain.proceed(originalRequest);
                }



               // Request request = originalRequest.newBuilder().build();
                //重组
                RequestBody body = originalRequest.body();
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                String oldJsonParams = buffer.readUtf8();
                Request newRequest = originalRequest.newBuilder().url(originalRequest.url().toString() +oldJsonParams).get().build();
                Response proceed = chain.proceed(newRequest);

                return proceed;
            }
        };
    }

    /**
     * 对外提供调用 API的接口
     *
     * @return
     */
    public static  APIService getApiService() {
        return apiService;
    }
}
