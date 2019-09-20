package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.event.UserInfoEvent;
import com.groundbuy.mine_model.mvp.contract.MineWithdrawContract;
import com.groundbuy.mine_model.mvp.model.MineWalletModel;
import com.groundbuy.mine_model.mvp.model.MineWithdrawModel;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.mvp.presenter.MineWithdrawPresenter;
import com.groundbuy.mine_model.utils.EditTextUtils;
import com.groundbuy.mine_model.widgets.dialog.ApplyDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

public class MineWithdrawActivity extends MineBaseActivity<MineWithdrawPresenter> implements MineWithdrawContract.IView {

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
    protected MineWithdrawPresenter initPresenter() {
        return new MineWithdrawPresenter(this, new MineWithdrawModel(this));
    }


    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        EditTextUtils.editAmount(etAmount);
        tvApply.setEnabled(false);
        if (BaseApplication.getUserBean().getBaseData().getAlipayId() == 0) {
            tvBind.setText("您还没有绑定支付宝账号，快去绑定");
        }
        initLintener();

    }

    private void initLintener() {
        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (Double.parseDouble(editable.toString()) > 2)//注意这里的2 是最低提现值，后台确定注意要改
                {
                    if (mTag == 0) {
                        if (BaseApplication.getUserBean().getBaseData().getAlipayId() != 0) {
                            tvApply.setEnabled(true);
                        }
                    } else {
                        if (BaseApplication.getUserBean().getBaseData().getWeixinId() != 0) {
                            tvApply.setEnabled(true);
                        }
                    }
                } else {
                    tvApply.setEnabled(false);
                }
            }
        });
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

                    if (BaseApplication.getUserBean().getBaseData().getAlipayId() == 0) {
                        tvBind.setText("您还没有绑定支付宝账号，快去绑定");
                        tvAccount.setText("");
                    } else {
                        tvAccount.setText("" + BaseApplication.getUserBean().getBaseData().getAlipayId());
                        tvBind.setText("修改支付宝账号");
                    }
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
                    if (BaseApplication.getUserBean().getBaseData().getWeixinId() == 0) {
                        tvBind.setText("您还没有绑定微信账号，快去绑定");
                        tvAccount.setText("");
                    } else {
                        tvAccount.setText("" + BaseApplication.getUserBean().getBaseData().getWeixinId());
                        tvBind.setText("修改微信账号");
                    }

                    mTag = 1;
                }
                break;
            case R.id.tv_bind:
                if (mTag == 0) {
                    if (BaseApplication.getUserBean().getBaseData().getAlipayId() == 0) {
                        startActivityForResult(new Intent(this, MineBindAWActivity.class).putExtra("tag", mTag), 10);
                    } else {//传参数过去
                        startActivityForResult(new Intent(this, MineBindAWActivity.class).putExtra("tag", mTag)
                                .putExtra("name", BaseApplication.getUserBean().getBaseData().getAlipayName())
                                .putExtra("id", BaseApplication.getUserBean().getBaseData().getAlipayId()), 10);
                    }
                } else {
                    if (BaseApplication.getUserBean().getBaseData().getWeixinId() == 0) {
                        startActivityForResult(new Intent(this, MineBindAWActivity.class).putExtra("tag", mTag), 10);
                    } else {//传参数过去
                        startActivityForResult(new Intent(this, MineBindAWActivity.class).putExtra("tag", mTag)
                                .putExtra("name", BaseApplication.getUserBean().getBaseData().getWeixinName())
                                .putExtra("id", BaseApplication.getUserBean().getBaseData().getWeixinId()), 10);
                    }
                }


                break;
            case R.id.tv_all:
                etAmount.setText("" + BaseApplication.getUserBean().getBaseData().getMoney());
                break;
            case R.id.tv_apply:
                if (mTag == 0) {
                    if (BaseApplication.getUserBean().getBaseData().getAlipayId() == 0) {
                        ToastUtils.showShort("您还没有绑定支付宝账号");
                    } else {
                        mPresenter.bindAlipay(mTag + "", etAmount.getText().toString().trim());
                    }
                } else {
                    if (BaseApplication.getUserBean().getBaseData().getWeixinId() == 0) {
                        ToastUtils.showShort("您还没有绑定微信账号");
                    } else {
                        mPresenter.bindWeixin(mTag + "", etAmount.getText().toString().trim());
                    }
                }

                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (mTag == 0) {
                tvBind.setText("修改支付宝账号");
                tvAccount.setText("" + BaseApplication.getUserBean().getBaseData().getAlipayId());
            } else {
                tvBind.setText("修改微信账号");
                tvAccount.setText("" + BaseApplication.getUserBean().getBaseData().getWeixinId());

            }

        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void withdrawalSu() {
        mDialog = new ApplyDialog(this, "申请已提交成功！", "我们将在1-3个工作日完成提现审核，请耐心等候！");
        mDialog.setonOkClickListener(new ApplyDialog.onOkClickListener() {
            @Override
            public void onClick() {
                mDialog.dismiss();
                EventBus.getDefault().post(new UserInfoEvent());
                finish();
            }
        });
        mDialog.show();
    }
}
