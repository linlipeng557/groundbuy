package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.groundbuy.R;
import com.groundbuy.mine_model.bean.CheckInBean;
import com.groundbuy.mine_model.bean.ConfigBean;
import com.groundbuy.mine_model.mvp.contract.MineCheckInContract;
import com.groundbuy.mine_model.mvp.model.MineCheckInModel;
import com.groundbuy.mine_model.mvp.presenter.MineCheckInPresenter;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineHelpCenterActivity extends MineBaseActivity<MineCheckInPresenter> implements MineCheckInContract.IView {


    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_help_center;
    }


    @Override
    protected MineCheckInPresenter initPresenter() {
        return new MineCheckInPresenter(this, new MineCheckInModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mPresenter.configInfo("config.help", 1);
    }


    @Override
    public void singResultSu(CheckInBean bean) {

    }

    @Override
    public void checkedInStatus(CheckInBean bean) {

    }



    @Override
    public void configInfoSu(ConfigBean bean, int i) {
        RichText.fromHtml(bean.getBaseData().getContent()).into(tvContent);
    }

    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
    }

}
