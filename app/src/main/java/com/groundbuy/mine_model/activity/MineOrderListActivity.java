package com.groundbuy.mine_model.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.OrderTypeAdapter;
import com.groundbuy.mine_model.fragment.OrderTypeFragment;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MineOrderListActivity extends MineBaseActivity {

    @BindView(R.id.tab_order)
    TabLayout tabOrder;
    @BindView(R.id.vp_order)
    ViewPager vpOrder;
    private OrderTypeAdapter mAdapter;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_order_list;
    }


    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        int tag = getIntent().getIntExtra("Type", 0);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(OrderTypeFragment.newInstance(OrderTypeFragment.ORDER_ALL));
        fragmentList.add(OrderTypeFragment.newInstance(OrderTypeFragment.ORDER_WAIT_PAY));
        fragmentList.add(OrderTypeFragment.newInstance(OrderTypeFragment.ORDER_WAIT_SHIP));
        fragmentList.add(OrderTypeFragment.newInstance(OrderTypeFragment.ORDER_WAIT_RECEIPT));
        fragmentList.add(OrderTypeFragment.newInstance(OrderTypeFragment.ORDER_WAIT_COMMENT));
        tabOrder.setTabRippleColor(ColorStateList.valueOf(getColor(R.color.transparent)));
        mAdapter = new OrderTypeAdapter(getSupportFragmentManager(), fragmentList);
        vpOrder.setAdapter(mAdapter);
        tabOrder.setupWithViewPager(vpOrder);
        vpOrder.setOffscreenPageLimit(5);
        if (tag != 0) {
            vpOrder.setCurrentItem(tag);
        }

    }


}
