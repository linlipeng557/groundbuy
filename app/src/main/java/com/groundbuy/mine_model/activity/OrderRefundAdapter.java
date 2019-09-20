package com.groundbuy.mine_model.activity;

import android.graphics.Paint;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.RefundListBean;
import com.groundbuy.mine_model.fragment.OrderTypeFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/17
 */
public class OrderRefundAdapter extends BaseQuickAdapter<RefundListBean.BaseDataBean.ListBean, BaseViewHolder> {
    public static final int ORDER_STATUS_0 = 0;//待付款
    public static final int ORDER_STATUS_1 = 1;//待发货
    public static final int ORDER_STATUS_2 = 2;//待收货
    public static final int ORDER_STATUS_3 = 3;//待评价
    public static final int ORDER_STATUS_4 = 4;//交易完成
    public static final int ORDER_STATUS_5 = 5;//交易关闭
    public static final int ORDER_STATUS_6 = 6;//售后

    public OrderRefundAdapter(@Nullable List<RefundListBean.BaseDataBean.ListBean> data) {
        super(R.layout.item_mine_order, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, RefundListBean.BaseDataBean.ListBean item) {
        helper.setGone(R.id.iv_more,false);
        helper.setText(R.id.tv_shop_name,"售后单号："+item.getOrderNumber());
        helper.setText(R.id.tv_count, "共" + item.getOrderAmount() + "件商品   合计");
        helper.setText(R.id.tv_num, "x" + item.getOrderAmount());
        helper.setText(R.id.tv_totoel_price, "￥" + item.getTotalPrice());
        helper.setText(R.id.tv_title, item.getGoodsName());
        helper.setText(R.id.tv_sku, item.getStockSpecs());
        helper.setText(R.id.tv_price, "￥" + item.getDiscountPrice());
        TextView oldTextView = helper.getView(R.id.tv_old_price);
        oldTextView.setText("￥" + item.getPrice());
        oldTextView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        if (item.getGoodsImgs() == null || item.getGoodsImgs().size() == 0) {
            Glide.with(mContext).load("").into((RoundedImageView) helper.getView(R.id.iv_user));

        } else {
            Glide.with(mContext).load(item.getGoodsImgs().get(0)).into((RoundedImageView) helper.getView(R.id.iv_user));
        }
        helper.setGone(R.id.tv_red, false);
        helper.setGone(R.id.tv_black_center, false);

        switch (item.getStatus()) {//2是申请成功， 1是售后成功，-1是失败，0是待审核，-2是已关闭售后
            case 2:
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setGone(R.id.tv_black_left, false);
                helper.setText(R.id.tv_sale,"1件商品正在售后");
                break;
            case 1:
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setGone(R.id.tv_black_left, false);
                helper.setGone(R.id.tv_sale,false);
                break;
            case 0:
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_333));
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_sale,false);
                helper.setText(R.id.tv_black_left, "关闭售后");
                break;
            case -1:
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_999));
                helper.setGone(R.id.tv_black_left, false);
                helper.setGone(R.id.tv_sale,false);

                break;
            case -2:

                break;
            default:
        }


        helper.addOnClickListener(R.id.tv_black_left);
    }
}
