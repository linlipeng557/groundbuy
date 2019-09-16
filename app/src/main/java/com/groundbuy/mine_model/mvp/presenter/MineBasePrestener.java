package com.groundbuy.mine_model.mvp.presenter;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public abstract class MineBasePrestener<V, M> {
    protected V mView;
    protected M mModel;
    protected Context mContext;
    public String Tag = this.getClass ().getSimpleName ();
    protected CompositeDisposable mCompositeDisposable;

    public MineBasePrestener(V view, M model) {
        this.mView = view;
        this.mModel = model;
        initContext();
    }


    private void initContext() {

        if (mView instanceof Fragment) {
            mContext = ((Fragment) mView).getActivity ();
        } else {
            mContext = (Activity) mView;
        }
    }

    /**
     * 将 {@link Disposable} 添加到 {@link CompositeDisposable} 中统一管理
     * 可在 {@link Activity#onDestroy()} 中使用 {@link #unDispose()} 停止正在执行的 RxJava 任务,避免内存泄漏
     *
     * @param disposable
     */

    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable ();
        }
        mCompositeDisposable.add (disposable);//将所有 Disposable 放入集中处理
    }

    /**
     * 停止集合中正在执行的 RxJava 任务
     */
    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear ();//保证 Activity 结束时取消所有正在执行的订阅
        }
    }

}
