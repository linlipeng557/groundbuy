package com.groundbuy.base;

import android.graphics.Color;
import android.os.Bundle;

import com.blankj.utilcode.util.BarUtils;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @LayoutRes
    public abstract Integer contentViewId();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        setContentView(contentViewId());
        ButterKnife.bind(this);
        doMore(savedInstanceState);
    }

    public abstract void doMore(@Nullable Bundle savedInstanceState);
}
