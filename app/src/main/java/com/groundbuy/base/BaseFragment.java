package com.groundbuy.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.BarUtils;
import com.groundbuy.R;
import com.groundbuy.http.ProgressListener;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements ProgressListener {

    Unbinder unbinder;


    @LayoutRes
    public abstract Integer contentViewLayout();

    public View topBar() {
        return null;
    }

    public abstract void doMore(@Nullable Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(contentViewLayout(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        if (topBar() != null) {
            BarUtils.addMarginTopEqualStatusBarHeight(topBar());
        }
        doMore(savedInstanceState);
        return rootView;
    }

    public void  setStatusBarLightMode(boolean isLightMode){
        BarUtils.setStatusBarLightMode(getActivity(),isLightMode);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    @Override
    public void showProgressDialog() {
        // TODO: 2019-09-09 show加载对话框
    }

    @Override
    public void dismissProgressDialog() {
        // TODO: 2019-09-09 dismiss 加载对话框
    }
}
