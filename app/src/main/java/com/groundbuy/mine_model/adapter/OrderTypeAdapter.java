package com.groundbuy.mine_model.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/4
 */
public class OrderTypeAdapter extends FragmentPagerAdapter {
    private String[] mStrs = new String[]{"全部", "待付款", "待发货", "待收货", "待评价"};
    private List<Fragment> fragmentList;

    public OrderTypeAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mStrs.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStrs[position];
    }
}
