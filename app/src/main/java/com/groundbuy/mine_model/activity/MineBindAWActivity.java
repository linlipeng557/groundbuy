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
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.mvp.contract.MineBindAWContract;
import com.groundbuy.mine_model.mvp.model.MineBindAWModel;
import com.groundbuy.mine_model.mvp.presenter.MineBindAWPresenter;
import com.groundbuy.mine_model.utils.EditTextUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MineBindAWActivity extends MineBaseActivity<MineBindAWPresenter> implements MineBindAWContract.IView {


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
    private String mName;
    private int mId;
    private int mType;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_bind_aw;
    }

    @Override
    protected MineBindAWPresenter initPresenter() {
        return new MineBindAWPresenter(this, new MineBindAWModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        ivChange.setVisibility(View.GONE);
        EditTextUtils.digistsNumberLetter(etAccount);
        EditTextUtils.editEmoji(etName);
        mTag = getIntent().getIntExtra("tag", 0);
        mName = getIntent().getStringExtra("name");
        mId = getIntent().getIntExtra("id", 0);
        if (mTag == 0 && TextUtils.isEmpty(mName)) {
            titleBar.setCenterTitle("绑定支付宝");
            ivType.setImageResource(R.mipmap.mine_tx_icon_ailipay);
            tvType.setText("支付宝账号");
            etAccount.setHint("请输入您的支付宝账号");
            etName.setHint("请输入与您支付宝一致的姓名");
            mType = 0;

        } else if (mTag == 0 && !TextUtils.isEmpty(mName)) {
            titleBar.setCenterTitle("修改支付宝账号");
            ivType.setImageResource(R.mipmap.mine_tx_icon_ailipay);
            tvType.setText("支付宝账号");
            etAccount.setHint("" + mId);
            etName.setHint(mName);
            mType = 1;
        } else if (mTag == 1 && TextUtils.isEmpty(mName)) {
            titleBar.setCenterTitle("绑定微信");
            ivType.setImageResource(R.mipmap.mine_tx_icon_wechat);
            tvType.setText("微信账号");
            etAccount.setHint("请输入您的支付宝账号");
            // ivChange.setVisibility(View.VISIBLE);
            etName.setHint("请输入与您微信一致的姓名");
            mType = 2;
        } else {
            titleBar.setCenterTitle("修改微信账号");
            ivType.setImageResource(R.mipmap.mine_tx_icon_wechat);
            tvType.setText("微信账号");
            etAccount.setHint("" + mId);
            //ivChange.setVisibility(View.VISIBLE);
            etName.setHint(mName);
            mType = 3;
        }
        initLintener();
    }

    private void initLintener() {
        etAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 6 && !TextUtils.isEmpty(etName.getText().toString().trim())) {
                    tvBind.setEnabled(true);
                } else {
                    tvBind.setEnabled(false);
                }
            }
        });
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 2 && !TextUtils.isEmpty(etAccount.getText().toString().trim())) {
                    tvBind.setEnabled(true);
                } else {
                    tvBind.setEnabled(false);
                }
            }
        });
    }


    @OnClick(R.id.tv_bind)
    public void onViewClicked() {

        if (mTag == 0) {
            mPresenter.bindAlipay(etAccount.getText().toString().trim(), etName.getText().toString().trim());
        } else {
             mPresenter.bindWeixin(etAccount.getText().toString().trim(), etName.getText().toString().trim());

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
    public void bindAlipaySu(String alipayId, String alipayName) {
        UserBean userBean = BaseApplication.getUserBean();
        userBean.getBaseData().setAlipayId(Integer.parseInt(alipayId));
        userBean.getBaseData().setAlipayName(alipayName);
        BaseApplication.setUserBean(userBean);
        if (mTag == 0) {
            ToastUtils.showShort("绑定支付宝账号成功");
        } else {
            ToastUtils.showShort("修改支付宝账号成功");
        }
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void bindWeixinSu(String weixinId, String weixinName) {
        UserBean userBean = BaseApplication.getUserBean();
        userBean.getBaseData().setWeixinId(Integer.parseInt(weixinId));
        userBean.getBaseData().setWeixinName(weixinName);
        BaseApplication.setUserBean(userBean);
        if (mTag == 1) {
            ToastUtils.showShort("绑定微信账号成功");
        } else {
            ToastUtils.showShort("修改微信账号成功");
        }
        setResult(RESULT_OK);

        finish();
    }
}
