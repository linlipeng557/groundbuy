package com.groundbuy.mine_model.widgets.dialog;


import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ScreenUtils;
import com.groundbuy.R;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class GeneralDialog extends Dialog {


    public GeneralDialog(@NonNull Context context) {
        super(context, R.style.dialog);

    }

    public GeneralDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected GeneralDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private Context context;
        private TextView tvHead, tvContent, tvLeft, tvRight;
        private View viewGeneralLine;
        private String mTitle, mContent, mLeft, mRight;
        private LeftAble leftAble;
        private RightAble rightAble;
        private LeftAndRightAble leftAndRightAble;
        private OneAble oneAble;
        private boolean mIsShow = true;
        private GeneralDialog dialog;
        private boolean mTitleShow = false;

        public Builder(Context context) {
            this.context = context;
        }

        //是否立马显示
        public Builder isShow(boolean boo) {
            this.mIsShow = boo;
            return this;
        }

        public interface LeftAble {
            void onClick(GeneralDialog dialog);
        }

        public interface RightAble {
            void onClick(GeneralDialog dialog);
        }

        public interface OneAble {
            void onClick(GeneralDialog dialog);
        }

        public interface LeftAndRightAble {
            void onLeftClick(GeneralDialog dialog);

            void onRightClick(GeneralDialog dialog);
        }


        //使用修改左边文字，
        public Builder setLeftButton(String left, LeftAble listener) {
            this.mLeft = left;
            this.leftAble = listener;
            return this;
        }

        public Builder setRightButton(String right, RightAble listener) {
            this.mRight = right;
            this.rightAble = listener;
            return this;
        }

        public Builder setLeftButton(LeftAble listener) {
            this.leftAble = listener;
            return this;
        }

        public Builder setRightButton(RightAble listener) {
            this.rightAble = listener;
            return this;
        }

        //使用默认文字
        public Builder setLeftAndRight(LeftAndRightAble listener) {
            this.leftAndRightAble = listener;
            return this;
        }

        public Builder setLeftAndRight(String left, String right, LeftAndRightAble listener) {
            this.mLeft = left;
            this.mRight = right;
            this.leftAndRightAble = listener;
            return this;
        }

        public Builder setOneButton(String one, OneAble listener) {
            this.mRight = one;
            this.oneAble = listener;
            return this;
        }

        //默认使用右边
        public Builder setOneButton(OneAble listener) {
            this.oneAble = listener;
            return this;
        }

        public Builder setTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder setContent(String content) {
            this.mContent = content;
            return this;
        }

        public Builder isTitleShow(boolean isShow) {
            this.mTitleShow = isShow;
            return this;
        }


        public GeneralDialog create() {
            dialog = new GeneralDialog(context);
            dialog.setContentView(R.layout.dialog_mine_general);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(true);
            tvHead = (TextView) dialog.findViewById(R.id.tv_general_head);
            tvContent = (TextView) dialog.findViewById(R.id.tv_general_content);
            tvLeft = (TextView) dialog.findViewById(R.id.tv_general_left);
            tvRight = (TextView) dialog.findViewById(R.id.tv_general_right);
            viewGeneralLine = (View) dialog.findViewById(R.id.view_general_line);


            if (!TextUtils.isEmpty(mTitle)) {
                tvHead.setText(mTitle);
            }
            if (!TextUtils.isEmpty(mContent)) {
                tvContent.setText(mContent);
            }

            if (leftAble != null) {
                if (!TextUtils.isEmpty(mLeft)) {
                    tvLeft.setText(mLeft);
                }
                tvLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        leftAble.onClick(dialog);
                    }
                });
            }
            if (rightAble != null) {
                if (!TextUtils.isEmpty(mRight)) {
                    tvRight.setText(mRight);
                }
                tvRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rightAble.onClick(dialog);
                    }
                });
            }

            if (leftAndRightAble != null) {
                if (!TextUtils.isEmpty(mLeft)) {
                    tvLeft.setText(mLeft);
                }
                if (!TextUtils.isEmpty(mRight)) {
                    tvRight.setText(mRight);
                }
                tvLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        leftAndRightAble.onLeftClick(dialog);
                    }
                });
                tvRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (leftAndRightAble != null) {
                            leftAndRightAble.onRightClick(dialog);
                        }
                    }
                });
            }

            if (oneAble != null) {
                if (!TextUtils.isEmpty(mRight)) {
                    tvRight.setText(mRight);
                }
                tvLeft.setVisibility(View.GONE);

                viewGeneralLine.setVisibility(View.GONE);
                tvRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        oneAble.onClick(dialog);
                    }
                });

            }

            Window window = dialog.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = (int) (ScreenUtils.getScreenWidth() * 0.8);    //宽度设置为屏幕的0.8
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setGravity(Gravity.CENTER);
            window.setAttributes(lp);

            if (mIsShow) {
                dialog.show();
            }
            if (mTitleShow) {
                tvHead.setVisibility(View.VISIBLE);
            } else {
                tvHead.setVisibility(View.GONE);
            }
            return dialog;
        }

    }
}
