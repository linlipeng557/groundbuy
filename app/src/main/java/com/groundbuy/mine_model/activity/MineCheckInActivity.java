package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.CheckInBean;
import com.groundbuy.mine_model.bean.ConfigBean;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.mvp.contract.MineCheckInContract;
import com.groundbuy.mine_model.mvp.model.MineCheckInModel;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.mvp.presenter.MineCheckInPresenter;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.OnClick;

public class MineCheckInActivity extends MineBaseActivity<MineCheckInPresenter> implements MineCheckInContract.IView {


    @BindView(R.id.tv_check_in)
    TextView tvCheckIn;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.tv_explanation)
    TextView tvExplanation;
    private int mUB;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_check_in;
    }


    @Override
    protected MineCheckInPresenter initPresenter() {
        return new MineCheckInPresenter(this, new MineCheckInModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mUB = BaseApplication.getUserBean().getBaseData().getUb();
        tvIntegral.setText(mUB + "UB");
        mPresenter.configInfo("config.sign.info", 1);
    }

    @Override
    public boolean statusBarLightMode() {
        return false;
    }

    @OnClick(R.id.tv_check_in)
    public void onViewClicked() {

    }

    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
    }


    @Override
    public void singResultSu(CheckInBean bean) {
        tvIntegral.setText(bean.getUbTotal() + "UB");
        UserBean userBean = BaseApplication.getUserBean();
        userBean.getBaseData().setUb(bean.getUbTotal());
        BaseApplication.setUserBean(userBean);
        ToastUtils.showShort("签到成功");
        tvCheckIn.setText("已签到" + bean.getSingTotal()+"天");
        tvCheckIn.setEnabled(false);
    }

    @Override
    public void checkedInStatus(CheckInBean bean) {
        ToastUtils.showShort("今天你已签到");
        tvCheckIn.setText("已签到" + bean.getSingTotal()+"天");
        tvCheckIn.setEnabled(false);
    }

    @Override
    public void configInfoSu(ConfigBean bean, int type) {
        RichText.fromHtml(bean.getBaseData().getContent()).into(tvExplanation);
        mPresenter.singResult();
    }
}
