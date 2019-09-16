package com.groundbuy.mine_model.widgets.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.groundbuy.R;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/2
 */
public class BottomSelectDilaog extends PopupWindow {
    private AppCompatActivity ac;
    private TextView tvTop;
    private TextView tvBottom;
    private TextView tvCancle;
    private int mType;

    public BottomSelectDilaog(AppCompatActivity context, int type) {
        super(context);
        this.ac = context;
        //type == 0 时，是选择头像，type==1时，是选择性别
        mType = type;
        initView();
    }

    public BottomSelectDilaog(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initView() {
        View view = LayoutInflater.from(ac).inflate(R.layout.popup_bottom_select, null);
        setContentView(view);
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        /// setAnimationStyle ();//动画
        setOutsideTouchable(false);//设置外部是否可以点击
        setFocusable(true);//按返回键是否可以dismiss
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setAnimationStyle(R.style.BottomDialogAnimation);
        tvTop = (TextView) view.findViewById(R.id.tv_top);
        tvBottom = (TextView) view.findViewById(R.id.tv_bottom);
        tvCancle = (TextView) view.findViewById(R.id.tv_cancle);
        if (mType == 1) {
            tvTop.setText("男");
            tvBottom.setText("女");
        }
        initListener();

    }

    private void initListener() {
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        tvBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onBottom();
                }
                dismiss();
            }
        });
        tvTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onTop();
                }
                dismiss();
            }
        });

    }

//    @Override
//    public void setOnDismissListener(OnDismissListener onDismissListener) {
//
//        changeBg(1f);//背景恢复正常
//        super.setOnDismissListener(onDismissListener);
//    }

    public void changeBg(float value) {
        WindowManager.LayoutParams params = ac.getWindow().getAttributes();
        params.alpha = value;
        ac.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ac.getWindow().setAttributes(params);
    }


    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        changeBg(0.7f);
        super.showAtLocation(parent, gravity, x, y);
    }

    public interface OnSelectListener {
        void onTop();

        void onBottom();
    }

    private OnSelectListener listener;

    public void setOnSelectListener(OnSelectListener selectListener) {
        this.listener = selectListener;
    }
}
