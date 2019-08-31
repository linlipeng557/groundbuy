package com.groundbuy.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.groundbuy.R;
import com.groundbuy.base.BaseFragment;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.top_bar)
    ConstraintLayout topBar;

    @Override
    public Integer contentViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public View topBar() {
        return topBar;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {

    }

    @OnClick(R.id.search_btn)
    public void onViewClicked() {
    }
}
