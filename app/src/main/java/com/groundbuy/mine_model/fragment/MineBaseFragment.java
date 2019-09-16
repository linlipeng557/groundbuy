package com.groundbuy.mine_model.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.groundbuy.base.BaseFragment;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.dialog.LoadingHorizontal;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/11
 */
public abstract class MineBaseFragment<P extends MineBasePrestener> extends BaseFragment {
    protected P mPresenter;
    private LoadingHorizontal mBaseDialog;
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
    }

    protected abstract P initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unDispose();
        }
        if (mBaseDialog != null) {
            mBaseDialog.dismiss();
            mBaseDialog = null;
        }
    }


    public void showBaseDialog() {
        if (mBaseDialog == null) {
            mBaseDialog = new LoadingHorizontal.Builder(getContext()).build();
            mBaseDialog.show();
        } else {
            mBaseDialog.show();
        }
    }

    public void dismissBaseDialog() {
        if (mBaseDialog != null) {
            mBaseDialog.dismiss();
        }
    }
}

