package com.groundbuy.mine_model.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.mine_model.activity.MineApplySaleActivity;
import com.groundbuy.mine_model.activity.MineCommontOrderActivity;
import com.groundbuy.mine_model.activity.MineLogisticsActivity;
import com.groundbuy.mine_model.activity.MineOrderDetailsActivity;
import com.groundbuy.mine_model.activity.OrderRefundAdapter;
import com.groundbuy.mine_model.adapter.OrderAdapter;
import com.groundbuy.mine_model.bean.OrderContentBean;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.bean.RefundListBean;
import com.groundbuy.mine_model.event.OrderEvent;
import com.groundbuy.mine_model.mvp.contract.OrderTypeContract;
import com.groundbuy.mine_model.mvp.model.OrderTypeModel;
import com.groundbuy.mine_model.mvp.presenter.OrderTypePresenter;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/4
 */
public class OrderTypeFragment extends MineBaseFragment<OrderTypePresenter> implements OrderTypeContract.IView {
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
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private String mType;
    private OrderAdapter mAdapter;
    private OrderRefundAdapter mRefundAdapter;
    private List<OrderContentBean> mListBean;
    private List<RefundListBean.BaseDataBean.ListBean> mListRefund;
    private int mPage = 1;
    private String mTag;

    @Override
    public Integer contentViewLayout() {
        return R.layout.fragment_order_type;
    }

    @Override
    protected OrderTypePresenter initPresenter() {
        return new OrderTypePresenter(this, new OrderTypeModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        EventBus.getDefault().register(this);
        mType = getArguments().getString("Type");
        mListBean = new ArrayList<>();
        mListRefund = new ArrayList<>();
        switch (mType) {//-9 全部 0待支付，1已支付待发货，2已发货待收货，3已收货，4已评价，-1退单，-2支付费用失败,-3,订单已关闭
            case ORDER_ALL:
                orderAdapter();
                mTag = "-9";
                mPresenter.getOrderLitst("-9", "" + mPage, "20");
                break;
            case ORDER_WAIT_PAY:
                orderAdapter();
                mTag = "0";
                mPresenter.getOrderLitst("0", "" + mPage, "20");
                break;
            case ORDER_WAIT_SHIP:
                orderAdapter();
                mTag = "1";
                mPresenter.getOrderLitst("1", "" + mPage, "20");
                break;
            case ORDER_WAIT_RECEIPT:
                orderAdapter();
                mTag = "2";
                mPresenter.getOrderLitst("2", "" + mPage, "20");
                break;
            case ORDER_WAIT_COMMENT:
                orderAdapter();
                mTag = "3";
                mPresenter.getOrderLitst("3", "" + mPage, "20");
                break;
            case ORDER_REFUND://售后
                orderRefundAdapter();
                mTag = "";
                mPresenter.getRundList("" + mPage, "20");
                break;
            default:
        }
        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mType == ORDER_REFUND) {
                    mPage++;
                    mPresenter.getRundList(mTag + mPage, "20");
                } else {
                    mPage++;
                    mPresenter.getOrderLitst(mTag, "" + mPage, "20");
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                rvOrder.scrollToPosition(0);
                if (mType == ORDER_REFUND) {
                    mPage = 1;
                    mPresenter.getRundList(mTag + mPage, "20");
                } else {
                    mPage = 1;
                    mPresenter.getOrderLitst(mTag, "" + mPage, "20");
                }
            }
        });

    }

    private void orderAdapter() {
        mAdapter = new OrderAdapter(mListBean);
        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrder.setAdapter(mAdapter);
        initListener();

    }

    //售后
    private void orderRefundAdapter() {
        mRefundAdapter = new OrderRefundAdapter(mListRefund);
        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrder.setAdapter(mRefundAdapter);
        initRefundListener();

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
                        startActivity(new Intent(getActivity(), MineCommontOrderActivity.class).putExtra("Type", "GO_COMMONT")
                                .putExtra("bean", mListBean.get(position)));
                        break;
                    case "查看评价":
                        startActivity(new Intent(getActivity(), MineCommontOrderActivity.class).putExtra("Type", "VIEW_COMMONT")
                                .putExtra("orderNumber", mListBean.get(position).getOrderNumber()));
                        break;
                    case "确认收货"://要判断是否在售后中 9不是，10在售后
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_9, mListBean.get(position).getOrderNumber());
                        //showDialog(MineOrderDetailsActivity.M_Order_Dialog_10);
                        break;
                    case "删除订单":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_11, mListBean.get(position).getOrderNumber());
                        break;
                    case "取消订单":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_12, mListBean.get(position).getOrderNumber());
                        break;
                    case "退款":
                        showDialog(MineOrderDetailsActivity.M_Order_Dialog_13, mListBean.get(position).getOrderNumber());
                        break;
                    case "关闭售后":
                        //showDialog(MineOrderDetailsActivity.M_Order_Dialog_14);
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
                        switch (mListBean.get(position).getOrderStatus()) {
                            case -1://退单售后
                                break;
                            default:
                                startActivity(new Intent(getActivity(), MineOrderDetailsActivity.class).putExtra("orderNumber", mListBean.get(position).getOrderNumber()));

                        }
                        break;
                    case ORDER_WAIT_PAY:
                    case ORDER_WAIT_SHIP:
                    case ORDER_WAIT_RECEIPT:
                    case ORDER_WAIT_COMMENT:
                        Log.d("FSDFSDF","AAAAAAAAAAA");
                        startActivity(new Intent(getActivity(), MineOrderDetailsActivity.class).putExtra("orderNumber", mListBean.get(position).getOrderNumber()));
                        break;
                    default:
                }


            }
        });
    }

    private void initRefundListener() {
        mRefundAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView tvView = (TextView) view;
                if ("关闭售后".equals(tvView.getText().toString().trim())) {
                    showDialog(MineOrderDetailsActivity.M_Order_Dialog_14, mListRefund.get(position).getOrderNumber());
                }

            }
        });

        mRefundAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                showDialog(MineOrderDetailsActivity.M_Order_Dialog_13, mListBean.get(position).getOrderNumber());
            }
        });
    }

    public void showDialog(int type, String order) {
        String mContent = null;
        String mSale = null, mService = null;
        switch (type) {
            case MineOrderDetailsActivity.M_Order_Dialog_9:
                mContent = "请确认收到该宝贝！";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_10:
                mContent = "您正在走售后流程，\n收货后将关闭售后单，您确定吗？";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_11:
                mContent = "确定要删除该订单？";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_12:
                mContent = "确定要取消该订单？";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_13:
                mContent = "只可申请一次售后，\n确定要继续走售后吗？";
                mSale = "继续售后";
                mService = "找客服聊聊";
                break;
            case MineOrderDetailsActivity.M_Order_Dialog_14:
                mContent = "关闭售后申请，\n 每个订单只可提交一次";
                break;
            default:
        }
        new GeneralDialog.Builder(getContext()).setContent(mContent).setLeftAndRight(mSale, mService, new GeneralDialog.Builder.LeftAndRightAble() {
            @Override
            public void onLeftClick(GeneralDialog dialog) {
                dialog.dismiss();
                if (type == 13) {
                    startActivity(new Intent(getActivity(), MineApplySaleActivity.class));
                }
            }

            @Override
            public void onRightClick(GeneralDialog dialog) {
                dialog.dismiss();
                switch (type) {
                    case MineOrderDetailsActivity.M_Order_Dialog_9://确认收货

                    case MineOrderDetailsActivity.M_Order_Dialog_10://关闭收货，确认订单
                        mPresenter.confirmReceiptOrder(order);
                        break;
                    case MineOrderDetailsActivity.M_Order_Dialog_11://删除
                        mPresenter.deleteOrder(order);
                        break;
                    case MineOrderDetailsActivity.M_Order_Dialog_12://取消
                        mPresenter.cancelOrder(order);
                        break;
                    case MineOrderDetailsActivity.M_Order_Dialog_13://申请售后， 退
                        break;
                    case MineOrderDetailsActivity.M_Order_Dialog_14://关闭售后
                        mPresenter.cancelRefund(order);
                        break;
                    default:
                }
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

    @Override
    public void getOrderLitstSu(OrderListBean bean) {
        smartRefresh.finishLoadMore();
        smartRefresh.finishRefresh();
        if (bean == null || bean.getBaseData() == null || bean.getBaseData().getList() == null || bean.getBaseData().getList().size() == 0) {
            smartRefresh.setEnableLoadMore(false);
            if (mListBean.size() == 0) {
                llNo.setVisibility(View.VISIBLE);
            } else {
                //暂无更多数据
            }
            return;
        } else {
            llNo.setVisibility(View.GONE);
        }

        if (bean.getBaseData().isFirstPage()) {
            mListBean.clear();
        }
        mListBean.addAll(bean.getBaseData().getList());
        if (bean.getBaseData().isLastPage()) {
            smartRefresh.setEnableLoadMore(false);
        } else {
            smartRefresh.setEnableLoadMore(true);
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void getRundList(RefundListBean bean) {
        smartRefresh.finishLoadMore();
        smartRefresh.finishRefresh();
        if (bean == null || bean.getBaseData() == null || bean.getBaseData().getList() == null || bean.getBaseData().getList().size() == 0) {
            smartRefresh.setEnableLoadMore(false);
            if (mListRefund.size() == 0) {
                llNo.setVisibility(View.VISIBLE);
            } else {
                //暂无更多数据
            }
            return;

        } else {
            llNo.setVisibility(View.GONE);
        }

        if (bean.getBaseData().isFirstPage()) {
            mListRefund.clear();
        }
        mListRefund.addAll(bean.getBaseData().getList());
        if (bean.getBaseData().isLastPage()) {
            smartRefresh.setEnableLoadMore(false);
        } else {
            smartRefresh.setEnableLoadMore(true);
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void cancelOrderSu() {
        ToastUtils.showShort("取消订单成功");
        smartRefresh.autoRefresh();
    }

    @Override
    public void deleteOrderSu() {
        ToastUtils.showShort("删除成功");
        smartRefresh.autoRefresh();
    }

    @Override
    public void confirmReceiptOrderSu() {
        ToastUtils.showShort("确认收货成功");
        smartRefresh.autoRefresh();
    }

    @Override
    public void cancelRefundSu() {
        ToastUtils.showShort("取消售后成功");
        smartRefresh.autoRefresh();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {
        if (smartRefresh.isRefreshing()) {
            smartRefresh.finishLoadMore();
            smartRefresh.finishRefresh();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(OrderEvent event) {
        smartRefresh.autoRefresh();
    }
}
