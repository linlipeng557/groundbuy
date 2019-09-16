package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import butterknife.BindView;
import butterknife.OnClick;

public class MineEditAddressActivity extends MineBaseActivity {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.tv_simple_address)
    TextView tvSimpleAddress;
    @BindView(R.id.et_details_address)
    EditText etDetailsAddress;
    @BindView(R.id.chb_default)
    CheckBox chbDefault;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    private int mType;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_edit_address;
    }


    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mType = getIntent().getIntExtra("Type", 0);
        if (mType == 0) {
            titleBar.setCenterTitle("添加地址");
        } else {
            titleBar.setCenterTitle("编辑地址");
            etName.setText("我家师姐");
            etPhone.setText("123456789");
            etDetailsAddress.setText("科韵路7享2好");
            tvSimpleAddress.setText("广东省广州市天河区");

        }


        chbDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chbDefault.setChecked(b);
            }
        });
    }

    @OnClick({R.id.tv_simple_address, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_simple_address:
                break;
            case R.id.tv_confirm:
                ToastUtils.showShort("保存成功");
                finish();
                break;
        }
    }
}
