package com.groundbuy.mine_model.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.groundbuy.R;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class LoadingHorizontal extends Dialog {
    public LoadingHorizontal(@NonNull Context context) {
        super(context, R.style.dialog);
    }

    public LoadingHorizontal(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingHorizontal(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private String mTvStr;
        private TextView mTv;
        private Context context;
        private boolean mCancel=true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTvText(String text) {
            this.mTvStr = text;
            return this;
        }

        public Builder isCancelable(boolean boo) {
            this.mCancel = boo;
            return this;
        }

        public LoadingHorizontal build() {
            LoadingHorizontal loading = new LoadingHorizontal(context);
            loading.setContentView(R.layout.dialog_horizontal_loading);
            loading.setCancelable(mCancel);
            loading.setCanceledOnTouchOutside(false);
            mTv = (TextView) loading.findViewById(R.id.text);
            if (!TextUtils.isEmpty(mTvStr)) {
                mTv.setText(mTvStr);
            }

            loading.show();
            return loading;
        }
    }

}
