package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.contract.MineChangeAccountContract;
import com.groundbuy.mine_model.mvp.model.MineChangeAccountModel;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.mvp.presenter.MineChangeAccountPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MineChangeAccountActivity extends MineBaseActivity<MineChangeAccountPresenter> implements MineChangeAccountContract.IView {


    @BindView(R.id.tv_bind_phone)
    TextView tvBindPhone;
    @BindView(R.id.tv_change_bind)
    TextView tvChangeBind;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_change_account;
    }

    @Override
    protected MineChangeAccountPresenter initPresenter() {
        return new MineChangeAccountPresenter(this, new MineChangeAccountModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        String phone = BaseApplication.getUserBean().getBaseData().getMobile();
        tvBindPhone.setText("您已绑定手机号码："+ phone.substring(0,4)+"****"+phone.substring(phone.length()-4));
    }


    @OnClick(R.id.tv_change_bind)
    public void onViewClicked() {
        startActivity(new Intent(this, MineVerifyOldActivity.class));
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }
}