package com.groundbuy.mine_model.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.groundbuy.R;
import com.groundbuy.mine_model.utils.OSUtils;


/**
 * @version V1.0 <描述当前版本功能>
 * @author: ade
 * @date: 2017-09-05
 */

public class CustomTitleBar extends ViewGroup {
    private static final int DEFAULT_CENTER_TITLE_TEXT_SIZE = 18;
    private static final int DEFAULT_LEFT_TITLE_TEXT_SIZE = 13;
    private static final int DEFAULT_RIGHT_TITLE_TEXT_SIZE = 13;
    private static final int DEFAULT_TITLE_BAR_HEIGHT = 48;
    private static final int DEFAULT_TITLE_TEXT_COLOR = 0xFF333333;
    private static final int DEFAULT_BACKGROUND_COLOR = 0xFFFFFFFF;
    private static final int DEFAULT_DIVIDER_COLOR = 0xFFF7F7F7;

    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";

    private View rootView;
    private TextView mTvLeftTitle;
    private ImageView mIvLeftTitle;
    private FrameLayout mFlLeftTitle;
    private TextView mTvTitle;
    private TextView mTvRightTitle;
    private ImageView mIvRightSecondTitle;
    private ImageView mIvRightTitle;
    private FrameLayout mFlRightTitle;
    private View mDivider;
    private View mStatusBar;


    private boolean mImmersive; //沉浸式

    private int mStatusBarHeight;
    private int mHeight;


    public CustomTitleBar(@NonNull Context context) {
        this(context, null);
    }

    public CustomTitleBar(@NonNull Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleBar(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setId(R.id.custom_toolbar);
        float density = getContext().getResources().getDisplayMetrics().density;
        initView(context);
        if (attrs != null) {
            final TypedArray typedArray = context.obtainStyledAttributes(attrs,
                    R.styleable.CustomTitleBar, defStyleAttr, 0);

            setImmersive(typedArray.getBoolean(R.styleable.CustomTitleBar_immersiv, false));
            setHeight((int) typedArray.getDimension(R.styleable.CustomTitleBar_titleBarHeight, DEFAULT_TITLE_BAR_HEIGHT * density));
            setBackgroundColor(typedArray.getColor(R.styleable.CustomTitleBar_backgroundColor, DEFAULT_BACKGROUND_COLOR));
            setLeftTitle(typedArray.getString(R.styleable.CustomTitleBar_leftTitle));
            setLeftTitleColor(typedArray.getColor(R.styleable.CustomTitleBar_leftTitleColor, DEFAULT_TITLE_TEXT_COLOR));
            setLeftTitleSize(typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_leftTitleSize, DEFAULT_LEFT_TITLE_TEXT_SIZE));

            setCenterTitle(typedArray.getString(R.styleable.CustomTitleBar_centerTitle));
            setCenterTitleColor(typedArray.getColor(R.styleable.CustomTitleBar_centerTitleColor, DEFAULT_TITLE_TEXT_COLOR));
            setCenterTitleSize(typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_centerTitleSize, DEFAULT_CENTER_TITLE_TEXT_SIZE));

            setRightTitle(typedArray.getString(R.styleable.CustomTitleBar_rightTitle));
            setRightTitleColor(typedArray.getColor(R.styleable.CustomTitleBar_rightTitleColor, DEFAULT_TITLE_TEXT_COLOR));
            setRightTitleSize(typedArray.getDimensionPixelSize(R.styleable.CustomTitleBar_rightTitleSize, DEFAULT_RIGHT_TITLE_TEXT_SIZE));
            setDivider(typedArray.getBoolean(R.styleable.CustomTitleBar_dividerShow, true));
            setDividerColor(typedArray.getColor(R.styleable.CustomTitleBar_dividerColor, DEFAULT_DIVIDER_COLOR));

            Drawable leftImage = typedArray.getDrawable(R.styleable.CustomTitleBar_leftImage);

            if (leftImage != null) {
                setLeftImage(leftImage);
            }
            Drawable rightImage = typedArray.getDrawable(R.styleable.CustomTitleBar_rightImage);
            if (rightImage != null) {
                setRightImage(rightImage);
            }
            Drawable rightSecondImage = typedArray.getDrawable(R.styleable.CustomTitleBar_rightSecondImage);
            if (rightSecondImage != null) {
                mIvRightSecondTitle.setVisibility(View.VISIBLE);
                mIvRightSecondTitle.setImageDrawable(rightSecondImage);
            } else {
                mIvRightSecondTitle.setVisibility(View.GONE);
            }
            typedArray.recycle();
        }
    }


    private void initView(Context context) {

        rootView = LayoutInflater.from(context).inflate(R.layout.layout_titlebar, this, false);
        mTvLeftTitle = (TextView) rootView.findViewById(R.id.tv_left_title);
        mIvLeftTitle = (ImageView) rootView.findViewById(R.id.iv_left_title);
        mFlLeftTitle = (FrameLayout) rootView.findViewById(R.id.fl_left_title);
        mTvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        mTvRightTitle = (TextView) rootView.findViewById(R.id.tv_right_title);
        mIvRightTitle = (ImageView) rootView.findViewById(R.id.iv_right_title);
        mFlRightTitle = (FrameLayout) rootView.findViewById(R.id.fl_right_title);
        mIvRightSecondTitle = (ImageView) rootView.findViewById(R.id.iv_right_second_image);
        mDivider = rootView.findViewById(R.id.divider);
        mStatusBar = rootView.findViewById(R.id.view_status_bar);


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                && !(OSUtils.isEMUI() || OSUtils.isMIUI() || OSUtils.isFlymeOS())) {
            mStatusBar.setVisibility(VISIBLE);
        } else {
            mStatusBar.setVisibility(GONE);
        }

        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(rootView, lp);

    }

    public void setImmersive(boolean immersive) {
        mImmersive = immersive;
        if (!mImmersive) {
            mStatusBarHeight = getStatusBarHeight();
        } else {
            mStatusBarHeight = 0;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mHeight = (int) ((int) (getResources().getDisplayMetrics().density * 48) + 0.5);
        int height = mHeight + mStatusBarHeight;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        LayoutParams layoutParams = mStatusBar.getLayoutParams();
        layoutParams.height = mStatusBarHeight;

        measureChild(rootView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        rootView.layout(0, 0, rootView.getMeasuredWidth(), rootView.getMeasuredHeight());
    }

    /**
     * 计算状态栏高度高度
     * getStatusBarHeight
     *
     * @return
     */
    public static int getStatusBarHeight() {
        return getInternalDimensionSize(Resources.getSystem(), STATUS_BAR_HEIGHT_RES_NAME);
    }


    private static int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }


    public void setHeight(int height) {
        mHeight = height;
        setMeasuredDimension(getMeasuredWidth(), mHeight);
    }

    public void setLeftImageResource(int resId) {
        mIvLeftTitle.setImageResource(resId);
        mIvLeftTitle.setVisibility(VISIBLE);
        mTvLeftTitle.setVisibility(GONE);
    }

    public void setLeftImage(Drawable drawable) {
        mIvLeftTitle.setImageDrawable(drawable);
        mIvLeftTitle.setVisibility(VISIBLE);
        mTvLeftTitle.setVisibility(GONE);
    }

    public void setRightImage(Drawable drawable) {
        mIvRightTitle.setImageDrawable(drawable);
        mIvRightTitle.setVisibility(VISIBLE);
        mTvRightTitle.setVisibility(GONE);
    }

    public void setRightImage(int resId) {
        mIvRightTitle.setImageResource(resId);
        mIvRightTitle.setVisibility(VISIBLE);
        mTvRightTitle.setVisibility(GONE);
    }


    public void setLeftTitle(CharSequence title) {
        if (TextUtils.isEmpty(title)) {
            mTvLeftTitle.setVisibility(GONE);
        } else {
            mTvLeftTitle.setText(title);
            mIvLeftTitle.setVisibility(GONE);
            mTvLeftTitle.setVisibility(VISIBLE);
        }
    }

    public void setLeftTitle(int resid) {
        setLeftTitle(getResources().getText(resid));
    }

    public void setLeftTitleSize(float size) {
        mTvLeftTitle.setTextSize(size);
    }

    public void setLeftTitleColor(int color) {
        mTvLeftTitle.setTextColor(color);
    }

    public void setCenterTitle(CharSequence title) {
        mTvTitle.setText(title);
    }

    public void setCenterTitle(int resid) {
        setCenterTitle(getResources().getString(resid));
    }


    public void setCenterTitleColor(int resid) {
        mTvTitle.setTextColor(resid);
    }

    public void setCenterTitleSize(float size) {
        mTvTitle.setTextSize(size);
    }

    public void setRightTitle(int resid) {
        setRightTitle(getResources().getString(resid));
    }

    public void setRightTitle(String rightTitle) {
        if (TextUtils.isEmpty(rightTitle)) {
            mTvRightTitle.setVisibility(GONE);
        } else {
            mTvRightTitle.setText(rightTitle);
            mTvRightTitle.setVisibility(GONE);
            mTvRightTitle.setVisibility(VISIBLE);
        }
    }

    public void setRightTitleColor(int resid) {
        mTvRightTitle.setTextColor(resid);
    }

    public void setRightTitleSize(float size) {
        mTvRightTitle.setTextSize(size);
    }

    private void setDivider(boolean divider) {
        if (divider) {
            mDivider.setVisibility(VISIBLE);
        } else {
            mDivider.setVisibility(GONE);
        }
    }

    public void setDividerColor(int color) {
        mDivider.setBackgroundColor(color);
    }

    public void setOnLeftClickListener(OnClickListener clickListener) {
        mFlLeftTitle.setOnClickListener(clickListener);
    }

    public void setOnRightClickListener(OnClickListener clickListener) {
        mFlRightTitle.setOnClickListener(clickListener);
    }

    public void setOnRightSecondTitleClickListener(OnClickListener clickListener) {
        mIvRightSecondTitle.setOnClickListener(clickListener);
    }

    public void addTextChangedListener(SearchTextWatcher watcher) {

        mListeners = watcher;
    }

    SearchTextWatcher mListeners;


    public interface SearchTextWatcher {

        public void beforeTextChanged(CharSequence s, int start, int count, int after);

        public void onTextChanged(CharSequence s, int start, int before, int count);

        public void afterTextChanged(Editable s);
    }

    public interface OnSearchListener {

        public void OnSearch(String str);

    }

    OnSearchListener onSearchListener;

    public void setOnSearchListener(OnSearchListener onSearchListener) {

        this.onSearchListener = onSearchListener;
    }

    public FrameLayout getmRightTitleView() {
        return mFlRightTitle;
    }

    public ImageView getIvRightSecondTitle() {
        return mIvRightSecondTitle;
    }

    public ImageView getIvRightTitle() {
        return mIvRightTitle;
    }
}
