package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import butterknife.BindView;
import butterknife.OnClick;

public class MineBindAWActivity extends MineBaseActivity {


    @BindView(R.id.iv_type)
    ImageView ivType;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.tv_real_name)
    TextView tvRealName;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_bind)
    TextView tvBind;
    @BindView(R.id.iv_change)
    ImageView ivChange;
    private int mTag;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_bind_aw;
    }
    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        ivChange.setVisibility(View.GONE);
        mTag = getIntent().getIntExtra("tag", 0);
        if (mTag == 0) {
            titleBar.setCenterTitle("绑定支付宝");
            ivType.setImageResource(R.mipmap.mine_tx_icon_ailipay);
            tvType.setText("支付宝账号");
            etAccount.setHint("请输入您的支付宝账号");
            etName.setHint("请输入与您支付宝一致的姓名");
        } else {
            titleBar.setCenterTitle("绑定微信");
            ivType.setImageResource(R.mipmap.mine_tx_icon_wechat);
            tvType.setText("微信账号");
            etAccount.setHint("修改微信");
            ivChange.setVisibility(View.VISIBLE);
            etName.setHint("请输入与您微信绑定的银行卡一致的姓名");
        }
    }


    @OnClick(R.id.tv_bind)
    public void onViewClicked() {
        ToastUtils.showShort("绑定成功");
    }
}
