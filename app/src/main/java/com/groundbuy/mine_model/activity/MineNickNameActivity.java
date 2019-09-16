package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.event.NickNameEventBus;
import com.groundbuy.mine_model.mvp.contract.MineNickNameContract;
import com.groundbuy.mine_model.mvp.model.MineNickNameModel;
import com.groundbuy.mine_model.mvp.presenter.MineNickNamePresenter;
import com.groundbuy.mine_model.widgets.dialog.LoadingHorizontal;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class MineNickNameActivity extends MineBaseActivity<MineNickNamePresenter> implements MineNickNameContract.IView {


    @BindView(R.id.et_nick)
    EditText etNick;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_nick_name;
    }


    @Override
    protected MineNickNamePresenter initPresenter() {
        return new MineNickNamePresenter(this, new MineNickNameModel(this));
    }


    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        etNick.setText(BaseApplication.getUserBean().getBaseData().getName());
        titleBar.setOnRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.changeNick(etNick.getText().toString());
                finish();
            }
        });
        etNick.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 10) {
                    String str = editable.toString();
                    etNick.setText(str.substring(0, 10));
                    etNick.setSelection(10);
                }
            }
        });
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
    public void changeNickSuccess(BaseEntiy base, String name) {
        UserBean userBean = BaseApplication.getUserBean();
        userBean.getBaseData().setName(name);
        BaseApplication.setUserBean(userBean);
        ToastUtils.showShort("修改昵称成功");
        EventBus.getDefault().post(new NickNameEventBus(name));
        finish();
    }
}
