package com.groundbuy.mine_model.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.base.BaseFragment;
import com.groundbuy.mine_model.activity.MineApplySaleActivity;
import com.groundbuy.mine_model.activity.MineCommontOrderActivity;
import com.groundbuy.mine_model.activity.MineLogisticsActivity;
import com.groundbuy.mine_model.activity.MineOrderDetailsActivity;
import com.groundbuy.mine_model.activity.MineRefundOrderActivity;
import com.groundbuy.mine_model.adapter.OrderAdapter;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/4
 */
public class OrderTypeFragment extends BaseFragment {
    public static final String ORDER_ALL = "wait_all";//全部
    public static final String ORDER_WAIT_PAY = "wait_pay";//待付款
    public static final String ORDER_WAIT_SHIP = "wait_ship";//代发货
    public static final String ORDER_WAIT_RECEIPT = "wait_receipt";//待收货
    public static final String ORDER_WAIT_COMMENT = "wait_comment";//待评价
    public static final String ORDER_REFUND = "order_refund";//售后
    @BindView(R.id.rv_order)
    RecyclerView rvOrder;
    @BindView(R.id.ll_no)
    LinearLayout llNo;
    private String mType;
    private OrderAdapter mAdapter;
    private List<OrderBean> mList;

    @Override
    public Integer contentViewLayout() {
        return R.layout.fragment_order_type;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        mType = getArguments().getString("Type");
        mList = new ArrayList<>();
        switch (mType) {
            case ORDER_ALL:
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_0, "待付款"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_2, "待收货"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_3, "待评价"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_1, "待发货"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_4, "交易完成"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_5, "交易关闭"));
                break;
            case ORDER_WAIT_PAY:
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_0, "待付款"));
                break;
            case ORDER_WAIT_SHIP:
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_1, "待发货"));
                break;
            case ORDER_WAIT_RECEIPT:
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_2, "待收货"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_2, "待收货"));
                break;
            case ORDER_WAIT_COMMENT:
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_3, "待评价"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_3, "待评价"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_3, "待评价"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_3, "待评价"));
                break;
            case ORDER_REFUND://售后
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_6, "售后成功"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_6, "申请成功"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_6, "售后审核中"));
                mList.add(new OrderBean(OrderAdapter.ORDER_STATUS_6, "售后被拒"));

                break;
            default:
        }

        mAdapter = new OrderAdapter(mList);
        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrder.setAdapter(mAdapter);
        initListener();
        //没有数据时
        if (mList.size() == 0) {
            llNo.setVisibility(View.VISIBLE);
            rvOrder.setVisibility(View.GONE);
        }
    }

    private void initListener() {
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView tvView = (TextView) view;
                switch (tvView.getText().toString()) {
                    case "付款":
                        break;
                    case "查看物流":
                        startActivity(new Intent(getActivity(), MineLogisticsActivity.class));
                        break;
                    case "评价":
                        startActivity(new Intent(getActivity(), MineCommontOrderActivity.class).putExtra("Type","GO_COMMONT"));
                        break;
                    case "查看评价":
                        startActivity(new Intent(getActivity(), MineCommontOrderActivity.class).putExtra("Type","VIEW_COMMONT"));
                        break;
                    case "确认收货"://要判断是否在售后中 9不是，10在售后
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_9);
                        //showDialog(MineOrderDetailsActivity.M_Order_Dialog_10);
                        break;
                    case "删除订单":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_11);
                        break;
                    case "取消订单":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_12);
                        break;
                    case "退款":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_13);
                        break;
                    case "关闭售后":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_14);
                        break;
                    default:
                }

            }
        });

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (mType) {
                    case ORDER_ALL:
                        if (position == 0)
                        {
                            startActivity(new Intent(getActivity(),MineOrderDetailsActivity.class).putExtra("Type",MineOrderDetailsActivity.M_ORDER_STATUS_5));
                        }else {
                            startActivity(new Intent(getActivity(),MineOrderDetailsActivity.class).putExtra("Type",MineOrderDetailsActivity.M_ORDER_STATUS_4));
                        }
                        break;
                    case ORDER_WAIT_PAY:
                        startActivity(new Intent(getActivity(),MineOrderDetailsActivity.class).putExtra("Type",MineOrderDetailsActivity.M_ORDER_STATUS_0));
                        break;
                    case ORDER_WAIT_SHIP:
                        startActivity(new Intent(getActivity(),MineOrderDetailsActivity.class).putExtra("Type",MineOrderDetailsActivity.M_ORDER_STATUS_1));
                        break;
                    case ORDER_WAIT_RECEIPT:
                        startActivity(new Intent(getActivity(),MineOrderDetailsActivity.class).putExtra("Type",MineOrderDetailsActivity.M_ORDER_STATUS_2));
                        break;
                    case ORDER_WAIT_COMMENT:
                        startActivity(new Intent(getActivity(),MineOrderDetailsActivity.class).putExtra("Type",MineOrderDetailsActivity.M_ORDER_STATUS_3));
                        break;
                    case ORDER_REFUND://售后
                        startActivity(new Intent(getActivity(), MineRefundOrderActivity.class).putExtra("Type",MineRefundOrderActivity.REFUND_STATUS_8));
                        break;
                    default:
                }


            }
        });
    }

    public void showDialog(int type) {
        String mContent = null;
        String mToast = null;
        String mSale = null, mService = null;
        switch (type) {
            case MineOrderDetailsActivity.M_Order_Dialog_9:
                mContent = "请确认收到该宝贝！";
                mToast = "收货成功";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_10:
                mContent = "您正在走售后流程，\n收货后将关闭售后单，您确定吗？";
                mToast = "收货成功";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_11:
                mContent = "确定要删除该订单？";
                mToast = "删除成功";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_12:
                mContent = "确定要取消该订单？";
                mToast = "取消成功";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_13:
                mContent = "只可申请一次售后，\n确定要继续走售后吗？";
                mToast = "申请售后成功";
                mSale = "继续售后";
                mService = "找客服聊聊";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_14:
                mContent = "关闭售后申请，\n 每个订单只可提交一次";
                mToast = "关闭成功";
                break;
            default:
        }
        String finalMToast = mToast;
        new GeneralDialog.Builder(getContext()).setContent(mContent).setLeftAndRight(mSale, mService, new GeneralDialog.Builder.LeftAndRightAble() {
            @Override
            public void onLeftClick(GeneralDialog dialog) {
                dialog.dismiss();
                if (type==13)
                {
                    startActivity(new Intent(getActivity(), MineApplySaleActivity.class));
                }
            }

            @Override
            public void onRightClick(GeneralDialog dialog) {
                ToastUtils.showShort(finalMToast);
                dialog.dismiss();
            }
        }).create();
    }

    public static OrderTypeFragment newInstance(String type) {
        OrderTypeFragment fragment = new OrderTypeFragment();
        Bundle args = new Bundle();
        args.putString("Type", type);
        fragment.setArguments(args);
        return fragment;
    }

    public static class OrderBean {
        private int status;
        private String type;

        public OrderBean(int status, String type) {
            this.status = status;
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
