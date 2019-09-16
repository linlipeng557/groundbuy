package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.dialog.ApplyDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class MineWithdrawActivity extends MineBaseActivity {

    @BindView(R.id.tv_alipay)
    TextView tvAlipay;
    @BindView(R.id.tv_wechat)
    TextView tvWechat;
    @BindView(R.id.iv_type)
    ImageView ivType;
    @BindView(R.id.tv_bind)
    TextView tvBind;
    @BindView(R.id.et_amount)
    EditText etAmount;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_min)
    TextView tvMin;
    @BindView(R.id.tv_apply)
    TextView tvApply;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    private int mTag;
    private ApplyDialog mDialog;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_withdraw;
    }



    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
    }


    @OnClick({R.id.tv_alipay, R.id.tv_wechat, R.id.tv_bind, R.id.tv_all, R.id.tv_apply})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_alipay:
                if (mTag != 0) {
                    tvAlipay.setBackgroundResource(R.color.colorPrimary);
                    tvWechat.setBackgroundResource(R.color.text_line_f7);
                    tvAlipay.setTextColor(getResources().getColor(R.color.white));
                    tvWechat.setTextColor(getResources().getColor(R.color.text_333));
                    ivType.setImageResource(R.mipmap.mine_tx_icon_ailipay);
                    tvBind.setText("您还没有绑定支付宝账号，快去绑定");
                    mTag = 0;
                }
                break;
            case R.id.tv_wechat:
                if (mTag != 1) {
                    tvAlipay.setBackgroundResource(R.color.text_line_f7);
                    tvWechat.setBackgroundResource(R.color.colorPrimary);
                    tvAlipay.setTextColor(getResources().getColor(R.color.text_333));
                    tvWechat.setTextColor(getResources().getColor(R.color.white));
                    ivType.setImageResource(R.mipmap.mine_tx_icon_wechat);
                    tvBind.setText("您还没有绑定微信账号，快去绑定");
                    mTag = 1;
                }
                break;
            case R.id.tv_bind:
                startActivity(new Intent(this, MineBindAWActivity.class).putExtra("tag", mTag));
                break;
            case R.id.tv_all:
                break;
            case R.id.tv_apply:
                mDialog = new ApplyDialog(this, "申请已提交成功！", "我们将在1-3个工作日完成提现审核，请耐心等候！");
                mDialog.setonOkClickListener(new ApplyDialog.onOkClickListener() {
                    @Override
                    public void onClick() {
                        mDialog.dismiss();
                        finish();
                    }
                });
                mDialog.show();
                break;
        }
    }


}
