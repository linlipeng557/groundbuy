package com.groundbuy.http;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class HttpObserver<T> implements Observer<HttpResult<T>> {
    ProgressListener progressListener;

    public HttpObserver(ProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    public HttpObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        startRequest();
    }

    @Override
    public void onNext(HttpResult<T> result) {
        endRequest();
        if (HttpResult.SUCCESS_CODE == result.getCode()) {
            onSuccessful(result.getCode(), result.getData(), result.getMsg());
        } else {
            onFailure(result.getCode(), result.getMsg(), null);
        }

    }

    @Override
    public void onError(Throwable e) {
        onFailure(-1, e.getMessage(), e);
        endRequest();

    }

    @Override
    public void onComplete() {

    }

    public void startRequest() {
        if (progressListener!=null){
            progressListener.showProgressDialog();
        }
    }

    public void endRequest() {
        if (progressListener!=null){
            progressListener.dismissProgressDialog();
        }
    }

    public abstract void onSuccessful(int code, T result, String msg);

    public abstract void onFailure(int code, String msg, Throwable e);
}
