package com.groundbuy.mine_model.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.fragment.OrderTypeFragment;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/4
 */
public class OrderAdapter extends BaseQuickAdapter<OrderTypeFragment.OrderBean, BaseViewHolder> {
    public static final int ORDER_STATUS_0 = 0;//待付款
    public static final int ORDER_STATUS_1 = 1;//待发货
    public static final int ORDER_STATUS_2 = 2;//待收货
    public static final int ORDER_STATUS_3 = 3;//待评价
    public static final int ORDER_STATUS_4 = 4;//交易完成
    public static final int ORDER_STATUS_5 = 5;//交易关闭
    public static final int ORDER_STATUS_6 = 6;//售后

    public OrderAdapter(@Nullable List<OrderTypeFragment.OrderBean> data) {
        super(R.layout.item_mine_order, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OrderTypeFragment.OrderBean item) {
        switch (item.getStatus()) {
            case ORDER_STATUS_0:
                helper.setText(R.id.tv_status, item.getType());
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorAccent));
                helper.setGone(R.id.tv_red, false);
                helper.setText(R.id.tv_black_left, "取消订单");
                helper.setText(R.id.tv_black_center, "付款");
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, true);
                helper.setGone(R.id.tv_red, false);
                break;
            case ORDER_STATUS_1:
                helper.setText(R.id.tv_status, item.getType());
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, false);
                helper.setText(R.id.tv_black_left, "退款");
                break;
            case ORDER_STATUS_2:
                helper.setText(R.id.tv_status, item.getType());
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setText(R.id.tv_red, "确认收货");
                helper.setGone(R.id.tv_red, true);
                helper.setGone(R.id.tv_black_left, false);
                helper.setGone(R.id.tv_black_center, true);
                helper.setText(R.id.tv_black_center, "查看物流");
                break;
            case ORDER_STATUS_3:
                helper.setText(R.id.tv_status, item.getType());
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                helper.setText(R.id.tv_red, "评价");
                helper.setGone(R.id.tv_red, true);
                helper.setGone(R.id.tv_black_left, false);
                helper.setGone(R.id.tv_black_center, false);
                break;
            case ORDER_STATUS_4:
                helper.setText(R.id.tv_status, item.getType());
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_333));
                helper.setGone(R.id.tv_red, false);
                helper.setText(R.id.tv_black_left, "删除订单");
                helper.setText(R.id.tv_black_center, "查看评价");
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, true);
                helper.setGone(R.id.tv_red, false);
                break;
            case ORDER_STATUS_5:
                helper.setText(R.id.tv_status, item.getType());
                helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_333));
                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_black_left, true);
                helper.setGone(R.id.tv_black_center, false);
                helper.setText(R.id.tv_black_left, "删除订单");
                break;
            case ORDER_STATUS_6:
                helper.setText(R.id.tv_status, item.getType());

                helper.setGone(R.id.tv_red, false);
                helper.setGone(R.id.tv_black_center, false);
                helper.setText(R.id.tv_black_left, "关闭售后");
                if ("售后成功".equals(item.getType())) {
                    helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                    helper.setGone(R.id.tv_black_left, false);
                } else if ("申请成功".equals(item.getType())) {
                    helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.colorPrimary));
                    helper.setGone(R.id.tv_black_left, false);
                } else if ("售后审核中".equals(item.getType())) {
                    helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_333));
                    helper.setGone(R.id.tv_black_left, true);
                } else if ("售后被拒".equals(item.getType())) {
                    helper.setTextColor(R.id.tv_status, mContext.getColor(R.color.text_999));
                    helper.setGone(R.id.tv_black_left, false);
                }
                break;

        }
        helper.addOnClickListener(R.id.tv_black_left, R.id.tv_black_center, R.id.tv_red);
    }
}
