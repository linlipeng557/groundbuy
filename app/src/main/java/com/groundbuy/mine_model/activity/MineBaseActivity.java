package com.groundbuy.mine_model.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.groundbuy.R;
import com.groundbuy.base.BaseActivity;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.CustomTitleBar;
import com.groundbuy.mine_model.widgets.dialog.LoadingHorizontal;

import butterknife.BindView;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public abstract class MineBaseActivity<P extends MineBasePrestener> extends BaseActivity {
    @Nullable
    @BindView(R.id.custom_toolbar)
    CustomTitleBar titleBar;
    protected P mPresenter;
    private LoadingHorizontal mBaseDialog;



    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        if (titleBar != null) {
            titleBar.setOnLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
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
            mBaseDialog = new LoadingHorizontal.Builder(this_()).build();
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

    @Override
    public Integer backBtnId() {
        return null;
    }
}
