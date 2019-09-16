package com.groundbuy.mine_model.adapter;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.http.RetrofitHandler;
import com.groundbuy.mine_model.bean.HistoryListBean;
import com.groundbuy.mine_model.widgets.CountDownView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class PugAdapter extends BaseQuickAdapter<HistoryListBean.BaseDataBean.ListBean, BaseViewHolder> {
    public PugAdapter(@Nullable List<HistoryListBean.BaseDataBean.ListBean> data) {
        super(R.layout.item_mine_goods, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HistoryListBean.BaseDataBean.ListBean item) {
        if (item.getGoodsImgs().size() == 0) {
            Glide.with(mContext).load(RetrofitHandler.BASE_URL + item.getGoodsImgs().get(0)).into((RoundedImageView) helper.getView(R.id.iv_user));
            helper.setVisible(R.id.iv_user, true);
        } else {
            helper.setVisible(R.id.iv_user, false);
        }
        //-2失效 1上架 -1下架
        switch (item.getProductStatus()) {
            case -2:
                helper.setGone(R.id.count_down, false);
                helper.setText(R.id.tv_status, "商品已失效");
                break;
            case 1:
                if (!TextUtils.isEmpty(item.getBaseDiscountEndTime())) {
                    helper.setGone(R.id.count_down, true);
                    helper.setText(R.id.tv_status, "剩余：");
                    CountDownView countDownView = helper.getView(R.id.count_down);
                    countDownView.setCountTime(item.getBaseDiscountEndTime()).startCountDown();
                } else {
                    helper.setGone(R.id.count_down, false);
                    helper.setText(R.id.tv_status, "商品上架中");
                }

                break;
            case -1:
                helper.setGone(R.id.count_down, false);
                helper.setText(R.id.tv_status, "商品已下架");
                break;
            default:
        }
        helper.setText(R.id.tv_mine_discount, "最低价：" + item.getMinDiscountRate() + "折");
        helper.setText(R.id.tv_return_ub, "返还" + item.getReturnUB() + "UB");
        helper.setText(R.id.tv_discount_price, "￥" + item.getDiscountPrice());

        TextView textView = helper.getView(R.id.tv_old_price);
        textView.setText("￥" + item.getPrice());
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);


    }
}
