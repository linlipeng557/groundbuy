package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class MineSettingActivity extends MineBaseActivity {

    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.rl_change_account)
    RelativeLayout rlChangeAccount;
    @BindView(R.id.rl_setting_pay)
    RelativeLayout rlSettingPay;
    @BindView(R.id.rl_setting_login)
    RelativeLayout rlSettingLogin;
    @BindView(R.id.rl_clear_cache)
    RelativeLayout rlClearCache;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.tv_logout)
    TextView tvLogout;
    private GeneralDialog mLogOutDialog;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_setting;
    }


    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
    }


    @OnClick({R.id.rl_address, R.id.rl_change_account, R.id.rl_setting_pay, R.id.rl_setting_login, R.id.rl_clear_cache, R.id.rl_about, R.id.tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                startActivity(new Intent(this,MineAddressActivity.class));
                break;
            case R.id.rl_change_account:
                startActivity(new Intent(this, MineChangeAccountActivity.class));
                break;
            case R.id.rl_setting_pay:
                startActivity(new Intent(this, MineSettingPayActivity.class).putExtra("Type",MineSettingPayActivity.M_PASSWORDTYPE_PAY));
                break;
            case R.id.rl_setting_login:
                startActivity(new Intent(this, MineSettingPayActivity.class).putExtra("Type",MineSettingPayActivity.M_PASSWORDTYPE_LOGIN));
                break;
            case R.id.rl_clear_cache:
                break;
            case R.id.rl_about:
                startActivity(new Intent(this, MineAboutActivity.class));
                break;
            case R.id.tv_logout:
                mLogOutDialog = new GeneralDialog.Builder(this)
                        .isTitleShow(false)
                        .setContent("您确定要退出登录吗？")
                        .setLeftAndRight(new GeneralDialog.Builder.LeftAndRightAble() {
                            @Override
                            public void onLeftClick(GeneralDialog dialog) {
                                dialog.dismiss();
                            }

                            @Override
                            public void onRightClick(GeneralDialog dialog) {
                                dialog.dismiss();
                                ToastUtils.showShort("退出成功");
                            }
                        })
                        .create();
                break;
            default:
        }
    }
}
