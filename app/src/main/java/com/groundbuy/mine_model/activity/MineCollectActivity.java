package com.groundbuy.mine_model.activity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.CollectAdapter;
import com.groundbuy.mine_model.fragment.GoodsFragment;
import com.groundbuy.mine_model.fragment.ShopFragment;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.SViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.utils.ScreenUtils;

public class MineCollectActivity extends MineBaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.tab_collect)
    TabLayout tabCollect;
    @BindView(R.id.vp_collect)
    SViewPager vpCollect;
    @BindView(R.id.view_status)
    View viewStatus;
    private List<Fragment> mList;
    private ShopFragment mShopFragment;
    private GoodsFragment mGoodsFragment;
    private boolean isEdit = true;
    private int mTag = 0;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_collect;
    }

    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }


    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewStatus.getLayoutParams();
            params.height = ScreenUtils.getStatusBarHeight();
            viewStatus.setLayoutParams(params);
        } else {
            viewStatus.setVisibility(View.GONE);
        }
        tabCollect.setTabRippleColor(ColorStateList.valueOf(getColor(R.color.white)));
        mList = new ArrayList<>();
        mShopFragment = new ShopFragment();
        mGoodsFragment = new GoodsFragment();
        mList.add(mShopFragment);
        mList.add(mGoodsFragment);
        vpCollect.setAdapter(new CollectAdapter(getSupportFragmentManager(), mList));
        tabCollect.setupWithViewPager(vpCollect);
        vpCollect.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tvEdit.setText("编辑");
                mShopFragment.setEdit(false);
                mGoodsFragment.setEdit(false);
                isEdit = true;
                mTag = position;
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_edit:
                if (mTag != 0 && isEdit)//代表现在选择的是店铺，点击下去就是商品了
                {
                    tvEdit.setText("完成");
                    mShopFragment.setEdit(false);
                    mGoodsFragment.setEdit(true);
                } else if (mTag != 0 && !isEdit) {

                    tvEdit.setText("编辑");
                    mShopFragment.setEdit(false);
                    mGoodsFragment.setEdit(false);
                } else if (mTag != 1 && isEdit) {
                    tvEdit.setText("完成");
                    mShopFragment.setEdit(true);
                    mGoodsFragment.setEdit(false);
                } else {//代表现在选择的是商品，点击下去就是店铺了
                    tvEdit.setText("编辑");
                    mShopFragment.setEdit(false);
                    mGoodsFragment.setEdit(false);
                }

                isEdit = !isEdit;
                break;
        }
    }

}
