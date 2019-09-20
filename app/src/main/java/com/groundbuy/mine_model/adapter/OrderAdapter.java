package com.groundbuy.mine_model.adapter;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.OrderContentBean;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.fragment.OrderTypeFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/4
 */
public class OrderAdapter extends BaseQuickAdapter<OrderContentBean, BaseViewHolder> {


    public OrderAdapter(@Nullable List<OrderContentBean> data) {
        super(R.layout.item_mine_order, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OrderContentBean item) {
        helper.setText(R.id.tv_shop_name, item.getShopName());
        helper.setText(R.id.tv_count, "共" + item.getAmount() + "件商品   合计");
        helper.setText(R.id.tv_num, "x" + item.getAmount());
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

        switch (item.getOrderStatus()) {//0待支付，1已支付待发货，2已发货待收货，3已收货，4已评价，-1退单，-2支付费用失败,-3,订单已关闭
            case 0://待付款
                helper.setText(R.id.tv_status, "待付款");
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorAccent));
                helper.setGone(R.id.tv_red, false);
                helper.setText(R.id.tv_black_left, "取消订单");
                helper.setText(R.id.tv_black_center, "付款");
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, true);
                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_sale, false);
                break;
            case 1://代发货
                helper.setText(R.id.tv_status, "待发货");
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, false);
                helper.setText(R.id.tv_black_left, "退款");
                helper.setGone(R.id.tv_sale, false);
                break;
            case 2://待收货
                helper.setText(R.id.tv_status, "待收货");
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setText(R.id.tv_red, "确认收货");
                helper.setGone(R.id.tv_red, true);
                helper.setGone(R.id.tv_black_left, false);
                helper.setGone(R.id.tv_black_center, true);
                helper.setText(R.id.tv_black_center, "查看物流");

                if (item.getRefundId() > 0) {
                    helper.setGone(R.id.tv_sale, true);
                    switch (item.getRefundStatus()) {
                        case 2://申请成功
                            helper.setText(R.id.tv_sale, "申请售后成功");
                            break;
                        case 1://售后成功
                            helper.setText(R.id.tv_sale, item.getRefundSuccess() + "件商品售后成功");
                            break;
                        case -1://失败
                            helper.setText(R.id.tv_sale, "售后失败");
                            break;
                        case 0://待审核
                            helper.setText(R.id.tv_sale, item.getRefundSuccess() + "件商品售后中");
                            break;
                        case -2://已关闭售后
                            helper.setText(R.id.tv_sale, "关闭售后");
                            break;
                        default:
                    }

                } else {
                    helper.setGone(R.id.tv_sale, false);
                }
                break;
            case 3://已收货，待评价
                helper.setText(R.id.tv_status, "交易完成");
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setText(R.id.tv_red, "评价");
                helper.setGone(R.id.tv_red, true);
                helper.setGone(R.id.tv_black_left, false);
                helper.setGone(R.id.tv_black_center, false);
                helper.setGone(R.id.tv_sale, false);
                break;
            case 4://交易完成，已评价
                helper.setText(R.id.tv_status, "交易完成");
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_333));
                helper.setGone(R.id.tv_red, false);
                helper.setText(R.id.tv_black_left, "删除订单");
                helper.setText(R.id.tv_black_center, "查看评价");
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, true);
                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_sale, false);
                break;
            case -3://交易关闭
                helper.setText(R.id.tv_status, "交易关闭");
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_333));
                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, false);
                helper.setText(R.id.tv_black_left, "删除订单");
                helper.setGone(R.id.tv_sale, false);
                break;

        }
        helper.addOnClickListener(R.id.tv_black_left, R.id.tv_black_center, R.id.tv_red);
    }
}
