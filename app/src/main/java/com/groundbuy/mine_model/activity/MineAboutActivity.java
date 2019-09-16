package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class MineAboutActivity extends MineBaseActivity {


    @BindView(R.id.tv_version_code)
    TextView tvVersionCode;
    @BindView(R.id.tv_new)
    TextView tvNew;
    @BindView(R.id.tv_about)
    TextView tvAbout;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_about;
    }


    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
    }

    @OnClick(R.id.tv_new)
    public void onViewClicked() {
        //已经是最新版本是
        ToastUtils.showShort("已是最新版本");
        //有新版本更新时
        new GeneralDialog.Builder(this).setLeftAndRight("以后再说", "立即升级", new GeneralDialog.Builder.LeftAndRightAble() {
            @Override
            public void onLeftClick(GeneralDialog dialog) {
                dialog.dismiss();
            }

            @Override
            public void onRightClick(GeneralDialog dialog) {
                dialog.dismiss();
                ToastUtils.showShort("升级成功");
            }
        }).create();
    }

    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
}
