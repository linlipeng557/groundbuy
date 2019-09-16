package com.groundbuy.mine_model.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/2
 */
public class CollectAdapter extends FragmentPagerAdapter {
    private String[] mStrs = new String[]{"店铺", "商品"};
    private List<Fragment> mList;

    public CollectAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;

    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
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
