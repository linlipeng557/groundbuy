package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.mvp.contract.MineSettingPayContract;
import com.groundbuy.mine_model.mvp.model.MineSettingPayModel;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.mvp.presenter.MineSettingPayPresenter;
import com.groundbuy.mine_model.widgets.dialog.LoadingHorizontal;

import butterknife.BindView;
import butterknife.OnClick;

public class MineSettingPayActivity extends MineBaseActivity<MineSettingPayPresenter> implements MineSettingPayContract.IView {
    public final static int M_PASSWORDTYPE_PAY = 0;
    public final static int M_PASSWORDTYPE_LOGIN = 1;

    @BindView(R.id.et_verify_code)
    EditText etVerifyCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.et_pay)
    EditText etPay;
    @BindView(R.id.et_repeat_pay)
    EditText etRepeatPay;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    private String mStrCode, mStrPay, mStrRepeatPay;
    private int mType;
    private CountDownTimer mTimer;
    private String mUUid;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_setting_pay;
    }



    @Override
    protected MineSettingPayPresenter initPresenter() {
        return new MineSettingPayPresenter(this, new MineSettingPayModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mType = getIntent().getIntExtra("Type", M_PASSWORDTYPE_PAY);
        String phone = BaseApplication.getUserBean().getBaseData().getMobile();
        tvPhone.setText("+86  " + phone.substring(0, 4) + "****" + phone.substring(phone.length() - 4));
        tvConfirm.setEnabled(false);
        if (mType == M_PASSWORDTYPE_PAY) {
            etPay.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            etRepeatPay.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            etPay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
            etRepeatPay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        } else {
            titleBar.setCenterTitle("修改登录密码");
            tvConfirm.setText("确认修改");
            etPay.setHint("请输入密码");
            etPay.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            etRepeatPay.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            etPay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
            etRepeatPay.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
        }

        etVerifyCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mStrCode = editable.toString();
                if (mType == M_PASSWORDTYPE_PAY) {
                    if (mStrCode.length() == 6 && etPay.getText().toString().trim().length() == 6 && etRepeatPay.getText().toString().trim().length() == 6) {
                        tvConfirm.setEnabled(true);
                    }
                } else {
                    if (mStrCode.length() == 6 && etPay.getText().toString().trim().length() >= 6 && etRepeatPay.getText().toString().trim().length() >= 6) {
                        tvConfirm.setEnabled(true);
                    }
                }

            }
        });
        etPay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mStrPay = editable.toString();
                if (mType == M_PASSWORDTYPE_PAY) {
                    if (etVerifyCode.getText().toString().trim().length() == 6 && mStrPay.length() == 6 && etRepeatPay.getText().toString().trim().length() == 6) {
                        tvConfirm.setEnabled(true);
                    }
                } else {
                    if (etVerifyCode.getText().toString().trim().length() == 6 && mStrPay.length() >= 6 && etRepeatPay.getText().toString().trim().length() == 6) {
                        tvConfirm.setEnabled(true);
                    }
                }

            }
        });
        etRepeatPay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mStrRepeatPay = editable.toString();
                if (mType == M_PASSWORDTYPE_PAY) {
                    if (etVerifyCode.getText().toString().trim().length() == 6 && etPay.getText().toString().trim().length() == 6 && etRepeatPay.getText().toString().trim().length() == 6) {
                        tvConfirm.setEnabled(true);
                    }
                } else {
                    if (etVerifyCode.getText().toString().trim().length() == 6 && etPay.getText().toString().trim().length() >= 6 && etRepeatPay.getText().toString().trim().length() >= 6) {
                        tvConfirm.setEnabled(true);
                    }
                }
            }
        });
    }


    @OnClick({R.id.tv_confirm, R.id.tv_get_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm:

                if (mStrPay.equals(mStrRepeatPay) && mType == M_PASSWORDTYPE_PAY) {
                    mPresenter.setPayword(mStrPay, etVerifyCode.getText().toString().trim(), mUUid);
                } else if (mStrPay.equals(mStrRepeatPay)) {
                    mPresenter.changeLogin(mStrPay, etVerifyCode.getText().toString().trim(), mUUid);
                } else {
                    ToastUtils.showShort("新旧密码不一致");
                }
                break;
            case R.id.tv_get_code:
                mPresenter.getVerifyCode();
                break;
        }

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
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    @Override
    public void getVerifyCodeSuccess(GetCodeBean bean) {
        if (mTimer != null) {
            mTimer.start();
        } else {
            downTime();
        }
        mUUid = bean.getBaseData().getUuid();
    }

    @Override
    public void changeLoginPasswordSuccess() {
        finish();
    }

    @Override
    public void setPayPasswordSu() {
        finish();
    }

    public void downTime() {
        mTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvGetCode.setText(millisUntilFinished / 1000 + "秒");
                tvGetCode.setEnabled(false);
            }

            @Override
            public void onFinish() {
                tvGetCode.setText("重新获得验证码");
                tvGetCode.setEnabled(true);
            }
        }.start();
    }

}
