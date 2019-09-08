package com.groundbuy.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.groundbuy.R;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.jessyan.autosize.utils.AutoSizeUtils;

public abstract class BaseDialog extends AlertDialog {
    private View rootView = null;
    private LinearLayout contentLl;

    private Context context;

    @LayoutRes
    public abstract int contentLayoutId();

    public int widthDP() {
        return 280;
    }

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.base_dialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       View rView = LayoutInflater.from(context).inflate(R.layout.dialog_base_1, null);
        setContentView(rView);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = AutoSizeUtils.dp2px(context, widthDP());
        getWindow().setAttributes(lp);
        contentLl = rView.findViewById(R.id.content_ll);
        rootView = LayoutInflater.from(context).inflate(contentLayoutId(), null);
        contentLl.addView(rootView);
        doMore(savedInstanceState);
    }

    public View getRootView() {
        return rootView;
    }

    public abstract void doMore(Bundle savedInstanceState);
}
