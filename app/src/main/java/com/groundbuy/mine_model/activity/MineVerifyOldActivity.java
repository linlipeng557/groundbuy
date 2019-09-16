package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.GetCodeBean;
import com.groundbuy.mine_model.mvp.contract.MineVerifyOldContract;
import com.groundbuy.mine_model.mvp.model.MineVerifyOldModelModel;
import com.groundbuy.mine_model.mvp.presenter.MineVerifyOldPresenter;
import com.groundbuy.mine_model.widgets.dialog.ApplyDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MineVerifyOldActivity extends MineBaseActivity<MineVerifyOldPresenter> implements MineVerifyOldContract.IView {


    @BindView(R.id.et_verify)
    EditText etVerify;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindView(R.id.ll_verify_edit)
    LinearLayout llVerifyEdit;
    @BindView(R.id.tv_verify_phone1)
    TextView tvVerifyPhone1;
    @BindView(R.id.check_1)
    CheckBox check1;
    @BindView(R.id.check_2)
    CheckBox check2;
    @BindView(R.id.check_3)
    CheckBox check3;
    @BindView(R.id.check_4)
    CheckBox check4;
    @BindView(R.id.ll_verify_load)
    LinearLayout llVerifyLoad;
    @BindView(R.id.tv_verify_phone)
    TextView tvVerifyPhone;
    @BindView(R.id.et_new_phone)
    EditText etNewPhone;
    @BindView(R.id.view_line)
    View viewLine;
    private Handler mHanlder;
    private Runnable mRunnable;
    private List<CheckBox> checkBoxList = new ArrayList<>();
    private int mTag;
    private int mChoose;
    private String mOldPhone;
    private CountDownTimer mTimer;
    private String mOldUUid, mNewUUid;
    private boolean isNewBing;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_verify_old;
    }



    @Override
    protected MineVerifyOldPresenter initPresenter() {
        return new MineVerifyOldPresenter(this, new MineVerifyOldModelModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        llVerifyEdit.setVisibility(View.VISIBLE);
        llVerifyLoad.setVisibility(View.GONE);
        tvVerify.setEnabled(false);
        mOldPhone = BaseApplication.getUserBean().getBaseData().getMobile();
        tvVerifyPhone.setText("您已绑定手机号码：" + mOldPhone.substring(0, 4) + "****" + mOldPhone.substring(mOldPhone.length() - 4));
        tvVerifyPhone1.setText("您已绑定手机号码：" + mOldPhone.substring(0, 4) + "****" + mOldPhone.substring(mOldPhone.length() - 4));
        loadAnim();
        etVerify.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 4) {
                    tvVerify.setEnabled(true);
                }
            }
        });
    }


    @OnClick({R.id.tv_get_code, R.id.tv_verify})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_code:
                if (!isNewBing)//第一次验证
                {
                    mPresenter.getVerifyCode();
                } else {//第二次验证
                    mPresenter.getGeneralCode(etNewPhone.getText().toString().trim());
                }
                break;
            case R.id.tv_verify:
                if (TextUtils.isEmpty(etVerify.getText().toString().trim().trim())) {
                    ToastUtils.showShort("请输入验证码");
                } else if (!isNewBing) {//验证
                    llVerifyEdit.setVisibility(View.GONE);
                    llVerifyLoad.setVisibility(View.VISIBLE);
                    mPresenter.verifyMobile(etVerify.getText().toString().trim(), mOldUUid);
                    isNewBing = true;
                } else {//开始绑定
                    mPresenter.changeMobile(etNewPhone.getText().toString().trim(), etVerify.getText().toString().trim(), mNewUUid);
                }
                break;

        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onDestroy() {
        if (mRunnable != null) {
            mRunnable = null;
        }
        if (mHanlder != null) {
            mHanlder = null;
        }
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        super.onDestroy();

    }

    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        if (isNewBing) {
            llVerifyEdit.setVisibility(View.VISIBLE);
            llVerifyLoad.setVisibility(View.GONE);
            isNewBing = false;
        }
        showBaseDialog();
    }


    @Override
    public void getVerifyCodeSuccess(GetCodeBean bean) {
        mOldUUid = bean.getUuid();
        if (mTimer == null) {
            downTime();
        } else {
            mTimer.start();
        }
    }

    @Override
    public void verifyMobileSuccess() {
        if (mTimer != null) {
            mTimer.cancel();
        }
        tvGetCode.setText("获得验证码");
        if (mHanlder != null && mRunnable != null) {
            mHanlder.removeCallbacksAndMessages(null);
            mRunnable = null;
            llVerifyEdit.setVisibility(View.VISIBLE);
            llVerifyLoad.setVisibility(View.GONE);
            viewLine.setVisibility(View.VISIBLE);
            etNewPhone.setVisibility(View.VISIBLE);
            tvVerifyPhone.setVisibility(View.INVISIBLE);
            titleBar.setCenterTitle("绑定新账号");
            tvVerify.setText("确认绑定");
            etVerify.setText("");
            tvVerify.setEnabled(false);
        }

    }

    @Override
    public void changeMobileSuccess() {
        ApplyDialog dialog = new ApplyDialog(this, "", "绑定成功");
        dialog.setonOkClickListener(new ApplyDialog.onOkClickListener() {
            @Override
            public void onClick() {
                dialog.dismiss();
                ActivityUtils.finishActivity(MineChangeAccountActivity.class);
                finish();
            }
        });
        dialog.show();
    }

    @Override
    public void getGeneralCodeSuccess(GetCodeBean bean) {
        mNewUUid = bean.getUuid();
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

    public void loadAnim() {
        checkBoxList.clear();
        checkBoxList.add(check1);
        checkBoxList.add(check2);
        checkBoxList.add(check3);
        checkBoxList.add(check4);
        mHanlder = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    if (i <= mChoose) {
                        checkBoxList.get(i).setChecked(true);
                    } else {
                        checkBoxList.get(i).setChecked(false);
                    }
                }
                mChoose++;
                if (mChoose == 4) {
                    mChoose = 0;
                    mTag++;
                }
                mHanlder.postDelayed(mRunnable, 300);

            }
        };
    }
}
