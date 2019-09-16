package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.groundbuy.R;
import com.groundbuy.mine_model.fragment.OrderTypeFragment;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import butterknife.BindView;

public class MineRefundActivity extends MineBaseActivity {

    @BindView(R.id.fl_refund)
    FrameLayout flRefund;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_refund;
    }

    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        FragmentManager fm= getSupportFragmentManager();;
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.fl_refund,OrderTypeFragment.newInstance(OrderTypeFragment.ORDER_REFUND));
        ft.commit();

    }

    @Override
    public boolean statusBarLightMode() {
        return false;
    }
}
