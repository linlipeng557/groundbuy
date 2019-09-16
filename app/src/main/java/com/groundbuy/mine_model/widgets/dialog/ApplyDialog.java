package com.groundbuy.mine_model.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ScreenUtils;
import com.groundbuy.R;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/2
 */
public class ApplyDialog extends Dialog {

    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvOk;

    public ApplyDialog(@NonNull Context context, String title, String content) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_apply);
        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        tvTitle.setText(title);
        tvContent.setText(content);
        if (TextUtils.isEmpty(title))
        {
            tvTitle.setVisibility(View.GONE);
        }
        tvOk = findViewById(R.id.tv_ok);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) ;
                {
                    listener.onClick();
                }
            }
        });
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width  = (int) (ScreenUtils.getScreenWidth()*0.8);
        getWindow().setAttributes(lp);
    }

    public ApplyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ApplyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public interface onOkClickListener {
        void onClick();
    }

    private onOkClickListener listener;

    public void setonOkClickListener(onOkClickListener onOkClickListener) {
        this.listener = onOkClickListener;
    }
}
