package com.groundbuy.mine_model.widgets;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.groundbuy.R;

import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class CountDownView extends LinearLayout {
    private static final int UPDATE_UI_CODE = 666;


    private Context context;
    private TextView hourTv, minuteTv, secondTv, hourColonTv, minuteColonTv;
    private long timeStamp;
    private boolean isContinue = false;
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    public CountDownView(Context context) {
        this(context, null);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    // 初始化方法
    private void init() {
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER_VERTICAL);
        hourTv = new TextView(context);
        hourTv.setTextColor(context.getResources().getColor(R.color.white));
        hourTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        hourTv.setGravity(Gravity.CENTER);
        //  hourTv.setPadding(8, 8, 8, 8);
        hourTv.getPaint().setFakeBoldText(true);
        this.addView(hourTv);

        hourColonTv = new TextView(context);
        hourColonTv.setTextColor(context.getResources().getColor(R.color.white));
        hourColonTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        hourColonTv.setText(":");
        //  hourColonTv.setPadding(8,0,8,0);
        hourColonTv.setGravity(Gravity.CENTER);
        hourColonTv.getPaint().setFakeBoldText(true);
        this.addView(hourColonTv);

        minuteTv = new TextView(context);
        minuteTv.setTextColor(Color.parseColor("#FFFFFF"));
        minuteTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        minuteTv.setGravity(Gravity.CENTER);
        // minuteTv.setPadding(8, 8, 8, 8);
        minuteTv.getPaint().setFakeBoldText(true);
        this.addView(minuteTv);

        minuteColonTv = new TextView(context);
        minuteColonTv.setTextColor(context.getResources().getColor(R.color.white));
        minuteColonTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        minuteColonTv.setText(":");
        minuteColonTv.setPadding(8, 0, 8, 0);
        minuteColonTv.setGravity(Gravity.CENTER);
        minuteColonTv.getPaint().setFakeBoldText(true);
        this.addView(minuteColonTv);

        secondTv = new TextView(context);
        secondTv.setTextColor(Color.parseColor("#FFFFFF"));
        secondTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        secondTv.setGravity(Gravity.CENTER);
        //   secondTv.setPadding(8, 8, 8, 8);
        secondTv.getPaint().setFakeBoldText(true);
        this.addView(secondTv);
    }


    public CountDownView setCountTime(Date timeStamp) {
        Date date = timeStamp;
        this.timeStamp = date.getTime();
        return this;
    }

    public CountDownView setCountTime(String timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        Date date = null;
        try {
            date = sdf.parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.timeStamp = date.getTime();
        return this;
    }

    /**
     * 开启
     */
    public CountDownView startCountDown() {
        if (timeStamp <= 1) {
            this.isContinue = false;
        } else {
            this.isContinue = true;
            countDown();
        }
        return this;
    }


    /**
     * 关闭
     */
    public CountDownView stopCountDown() {
        this.timeStamp = 0;
        return this;
    }

    /**
     * 销毁
     */
    public void destoryCountDownView() {
        if (mExecutorService != null)
            mExecutorService.shutdownNow();
        if (myHandler != null) {
            myHandler.removeCallbacksAndMessages(null);
            myHandler = null;
        }
    }


    private void countDown() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isContinue) {
                        isContinue = timeStamp-- > 1;
                        String[] times = secToTimes(timeStamp);
                        Message message = new Message();
                        message.obj = times;
                        message.what = UPDATE_UI_CODE;
                        myHandler.sendMessage(message);
                        // 沉睡一秒
                        Thread.sleep(1000);
                    }
                    isContinue = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (mExecutorService == null || mExecutorService.isShutdown())
            mExecutorService = Executors.newCachedThreadPool();
        mExecutorService.execute(thread);
    }

    public static String[] secToTimes(long time) {
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String[] timeStrs = new String[3];
        long defferenttime = time - curDate.getTime();
        long centerNumber = 3600000;
        if (defferenttime <= 0) {
            timeStrs[0] = String.format("%02d", 0);
            timeStrs[1] = String.format("%02d", 0);
            timeStrs[2] = String.format("%02d", 0);
        } else {
            int hour = (int) (defferenttime / centerNumber);
            int minute = (int) ((defferenttime - hour * centerNumber) / (1000 * 60));
            int seconds = (int) ((defferenttime - hour * centerNumber) - minute * (1000 * 60)) / 1000;
            timeStrs[0] = String.format("%02d", hour);
            timeStrs[1] = String.format("%02d", minute);
            timeStrs[2] = String.format("%02d", seconds);

        }
        return timeStrs;
    }


    private void updateTvText(String text, TextView textView) {
        textView.setText(text);
    }

    private Handler myHandler = new MyHandler(this);

    static class MyHandler extends Handler {
        // 定义一个对象用来引用Activity中的方法
        private final WeakReference<CountDownView> mCountDownView;

        MyHandler(CountDownView countDownView) {
            mCountDownView = new WeakReference<>(countDownView);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CountDownView currentCountDownView = mCountDownView.get();
            switch (msg.what) {
                case UPDATE_UI_CODE:// 刷新UI
                    if (msg.obj != null) {
                        String[] times = (String[]) msg.obj;
                        for (int i = 0; i < times.length; i++) {
                            switch (i) {
                                case 0:
                                    currentCountDownView.updateTvText(times[0], currentCountDownView.hourTv);
                                    break;
                                case 1:
                                    currentCountDownView.updateTvText(times[1], currentCountDownView.minuteTv);
                                    break;
                                case 2:
                                    currentCountDownView.updateTvText(times[2], currentCountDownView.secondTv);
                                    break;
                            }
                        }
                    }

                    if (!currentCountDownView.isContinue) {
                        if (currentCountDownView.countDownEndListener != null)
                            currentCountDownView.countDownEndListener.onCountDownEnd();
                    }
                    break;
            }
        }
    }

    /**
     * 小时控件背景
     */
    public CountDownView setHourTvBackgroundRes(int res) {
        hourTv.setBackgroundResource(res);
        return this;
    }

    /**
     * 小时控件字体大小
     */
    public CountDownView setHourTvTextSize(float size) {
        hourTv.setTextSize(size);
        return this;
    }

    /**
     * 小时控件字体颜色
     */
    public CountDownView setHourTvTextColorHex(String colorHex) {
        int color = Color.parseColor(colorHex);
        hourTv.setTextColor(color);
        return this;
    }


    /**
     * 分钟控件背景
     */
    public CountDownView setMinuteTvBackgroundRes(int res) {
        minuteTv.setBackgroundResource(res);
        return this;
    }


    /**
     * 分钟控件字体大小
     */
    public CountDownView setMinuteTvTextSize(float size) {
        minuteTv.setTextSize(size);
        return this;
    }

    /**
     * 分钟控件字体颜色
     */
    public CountDownView setMinuteTvTextColorHex(String colorHex) {
        int color = Color.parseColor(colorHex);
        minuteTv.setTextColor(color);
        return this;
    }


    /**
     * 秒控件背景
     */
    public CountDownView setSecondTvBackgroundRes(int res) {
        secondTv.setBackgroundResource(res);
        return this;
    }

    /**
     * 秒控件字体大小
     */
    public CountDownView setSecondTvTextSize(float size) {
        secondTv.setTextSize(size);
        return this;
    }

    /**
     * 秒控件字体颜色
     */
    public CountDownView setSecondTvTextColorHex(String colorHex) {
        int color = Color.parseColor(colorHex);
        secondTv.setTextColor(color);
        return this;
    }


    /**
     * 第一个冒号控件颜色
     */
    public CountDownView setHourColonTvTextColorHex(String colorHex) {
        int color = Color.parseColor(colorHex);
        hourColonTv.setTextColor(color);
        return this;
    }


    /**
     * 第二个冒号控件颜色
     */
    public CountDownView setMinuteColonTvTextColorHex(String colorHex) {
        int color = Color.parseColor(colorHex);
        minuteColonTv.setTextColor(color);
        return this;
    }

    public interface CountDownEndListener {
        void onCountDownEnd();
    }

    private CountDownEndListener countDownEndListener;

    public void setCountDownEndListener(CountDownEndListener countDownEndListener) {
        this.countDownEndListener = countDownEndListener;
    }

}
