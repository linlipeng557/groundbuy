package com.groundbuy.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.BarUtils;
import com.groundbuy.R;
import com.groundbuy.http.ProgressListener;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements ProgressListener {

    @Nullable
    @BindView(R.id.top_bar)
    ConstraintLayout topBar;


    public static void startActivityClass(Context context, Class cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    @LayoutRes
    public abstract Integer contentViewId();

    @IdRes
    public Integer backBtnId() {
        return R.id.back_btn;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        setContentView(contentViewId());
        ButterKnife.bind(this);
        if (topBar() != null) {
            BarUtils.addMarginTopEqualStatusBarHeight(topBar());
        }
        if (backBtnId() != null)
            findViewById(backBtnId()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        doMore(savedInstanceState);
    }

    public abstract void doMore(@Nullable Bundle savedInstanceState);


    public View topBar() {
        return topBar;
    }

    @Override
    protected void onStart() {
        super.onStart();
        BarUtils.setStatusBarLightMode(this, statusBarLightMode());
    }


    public boolean statusBarLightMode(){
        return true;
    }

    public BaseActivity this_() {
        return this;
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
