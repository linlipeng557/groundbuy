package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.OrderContentBean;
import com.groundbuy.mine_model.bean.OrderDetailsBean;
import com.groundbuy.mine_model.bean.OrderListBean;
import com.groundbuy.mine_model.bean.RefundListBean;
import com.groundbuy.mine_model.event.OrderEvent;
import com.groundbuy.mine_model.mvp.contract.MineOrderDetailsContract;
import com.groundbuy.mine_model.mvp.model.MineOrderDetailsModel;
import com.groundbuy.mine_model.mvp.presenter.MineOrderDetailsPresenter;
import com.groundbuy.mine_model.utils.MineDateUtils;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;
import com.makeramen.roundedimageview.RoundedImageView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineOrderDetailsActivity extends MineBaseActivity<MineOrderDetailsPresenter> implements MineOrderDetailsContract.IView {
    public static final int M_Order_Dialog_9 = 9;//收货没有收货
    public static final int M_Order_Dialog_10 = 10;//处于售后
    public static final int M_Order_Dialog_11 = 11;//删除订单
    public static final int M_Order_Dialog_12 = 12;//取消订单
    public static final int M_Order_Dialog_13 = 13;//退款
    public static final int M_Order_Dialog_14 = 14;//关闭售后
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_time_cancel)
    TextView tvTimeCancel;
    @BindView(R.id.tv_person)
    TextView tvPerson;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.iv_user)
    RoundedImageView ivUser;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_sku)
    TextView tvSku;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_create_time)
    TextView tvCreateTime;
    @BindView(R.id.tv_close_time)
    TextView tvCloseTime;
    @BindView(R.id.tv_pay_time)
    TextView tvPayTime;
    @BindView(R.id.tv_fahuo_time)
    TextView tvFahuoTime;
    @BindView(R.id.tv_shouhuo_time)
    TextView tvShouhuoTime;
    @BindView(R.id.tv_logistics)
    TextView tvLogistics;
    @BindView(R.id.tv_sale)
    TextView tvSale;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_refund)
    TextView tvRefund;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_commont)
    TextView tvCommont;
    @BindView(R.id.tv_view_commont)
    TextView tvViewCommont;
    @BindView(R.id.nest_view)
    NestedScrollView nestView;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_goods_price)
    TextView tvGoodsPrice;
    @BindView(R.id.tv_goods_old_price)
    TextView tvGoodsOldPrice;
    @BindView(R.id.tv_fee)
    TextView tvFee;
    @BindView(R.id.tv_total_num)
    TextView tvTotalNum;
    @BindView(R.id.tv_total_pice)
    TextView tvTotalPice;
    @BindView(R.id.tv_totle_old_price)
    TextView tvTotleOldPrice;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.tv_commont_time)
    TextView tvCommontTime;
    private OrderContentBean mBean;
    private String mOrderNum;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_order_details;
    }

    @Override
    protected MineOrderDetailsPresenter initPresenter() {
        return new MineOrderDetailsPresenter(this, new MineOrderDetailsModel(this));
    }


    @Override
    public boolean statusBarLightMode() {
        return false;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mOrderNum = getIntent().getStringExtra("orderNumber");

        nestView.setVisibility(View.GONE);
        mPresenter.orderDetail(mOrderNum);

    }


    @OnClick({R.id.tv_name, R.id.tv_logistics, R.id.tv_sale, R.id.tv_confirm, R.id.tv_delete, R.id.tv_cancel, R.id.tv_pay, R.id.tv_refund, R.id.tv_commont, R.id.tv_view_commont})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_name:
                break;
            case R.id.tv_logistics:
                break;
            case R.id.tv_sale:
                dialogShow(M_Order_Dialog_13, mBean.getOrderNumber());
                break;
            case R.id.tv_confirm:
                // dialogShow(M_Order_Dialog_9);
                dialogShow(M_Order_Dialog_10, mBean.getOrderNumber());
                break;
            case R.id.tv_delete:
                dialogShow(M_Order_Dialog_11, mBean.getOrderNumber());
                break;
            case R.id.tv_cancel:
                dialogShow(M_Order_Dialog_12, mBean.getOrderNumber());
                break;
            case R.id.tv_pay:
                break;
            case R.id.tv_refund:
                dialogShow(M_Order_Dialog_13, mBean.getOrderNumber());
                break;
            case R.id.tv_commont:
                startActivity(new Intent(this, MineCommontOrderActivity.class).putExtra("Type", "GO_COMMONT")
                        .putExtra("bean", mBean));
                break;
            case R.id.tv_view_commont:
                startActivity(new Intent(this, MineCommontOrderActivity.class).putExtra("Type", "VIEW_COMMONT")
                .putExtra("orderNumber",mBean.getOrderNumber()));
                break;

        }
    }

    public void dialogShow(int type, String order) {
        String mContent = null;
        String mSale = null, mService = null;
        switch (type) {
            case M_Order_Dialog_9:
                mContent = "请确认收到该宝贝！";
                break;
            case M_Order_Dialog_10:
                mContent = "您正在走售后流程，\n收货后将关闭售后单，您确定吗？";
                break;
            case M_Order_Dialog_11:
                mContent = "确定要删除该订单？";
                break;
            case M_Order_Dialog_12:
                mContent = "确定要取消该订单？";
                break;
            case M_Order_Dialog_13:
                mContent = "只可申请一次售后，\n确定要继续走售后吗？";
                mSale = "继续售后";
                mService = "找客服聊聊";
                break;
            default:
        }
        new GeneralDialog.Builder(this).setContent(mContent).setLeftAndRight(mSale, mService, new GeneralDialog.Builder.LeftAndRightAble() {
            @Override
            public void onLeftClick(GeneralDialog dialog) {
                dialog.dismiss();
                if (type == M_Order_Dialog_13) {
                    startActivity(new Intent(MineOrderDetailsActivity.this, MineApplySaleActivity.class));
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


    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
    }

    @Override
    public void orderDetailSu(OrderDetailsBean bean) {
        if (bean == null) {
            nestView.setVisibility(View.GONE);
            ToastUtils.showShort("好像有问题哦");
            return;
        }
        mBean = bean.getOrder();
        tvTimeCancel.setVisibility(View.GONE);
        tvTimeCancel.setText("");
        tvName.setText(bean.getAddress().getName());
        tvPhone.setText(bean.getAddress().getMobile());
        tvAddress.setText("收货地址：" + bean.getAddress().getProvince() + bean.getAddress().getCity() + bean.getAddress().getArea() + bean.getAddress().getAddress());
        tvShopName.setText(bean.getOrder().getShopName());
        if (bean.getOrder().getGoodsImgs() != null && bean.getOrder().getGoodsImgs().size() != 0) {
            Glide.with(this_()).load(bean.getOrder().getGoodsImgs().get(0)).into(ivUser);
        } else {
            Glide.with(this_()).load("").into(ivUser);
        }
        tvTitle.setText(bean.getOrder().getGoodsName());
        tvSku.setText(bean.getOrder().getStockSpecs());
        tvPrice.setText("￥" + bean.getOrder().getDiscountPrice());
        tvOldPrice.setText("￥" + bean.getOrder().getPrice());
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvNum.setText("x" + bean.getOrder().getAmount());
        tvGoodsOldPrice.setText("￥" + bean.getOrder().getPrice());
        tvGoodsOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvGoodsPrice.setText("￥" + bean.getOrder().getDiscountPrice());
        tvFee.setText("￥" + bean.getOrder().getLogisticsPrice());
        tvTotalNum.setText("共" + bean.getOrder().getAmount() + "件商品  合计");
        tvTotalPice.setText("￥" + bean.getOrder().getTotalPrice());
        tvTotleOldPrice.setText("￥" + (bean.getOrder().getLogisticsPrice() + bean.getOrder().getAmount() * bean.getOrder().getPrice()));
        tvTotleOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvOrder.setText("订单编号：" + bean.getOrder().getOrderNumber());
        tvCreateTime.setText("创建时间：" + bean.getOrder().getCreateTime());
        if (TextUtils.isEmpty(bean.getOrder().getRemark())) {
            tvRemark.setVisibility(View.GONE);
        } else {
            tvRemark.setText("备注：" + bean.getOrder().getRemark());
        }

        switch (bean.getOrder().getOrderStatus()) {
            case 0:///待付款                //已改
                tvContent.setText("买家未付款");
                tvStatus.setText("");
                tvTimeCancel.setVisibility(View.VISIBLE);
                tvTimeCancel.setText("5小时23分后关闭订单");
                tvCancel.setVisibility(View.VISIBLE);
                tvPay.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.GONE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                tvCommontTime.setVisibility(View.GONE);
                if (bean.getWaitPayTime() <= 0) {
                    tvTimeCancel.setText("订单超时");
                } else {
                    // mPayTimer = new DownTimer(bean.getWaitPayTime(), 1000);
                    tvTimeCancel.setText(convrt(bean.getWaitPayTime() * 1000));
                }

                break;
            case 1://待发货，，要判断是否申请了售后，是否售后成功，还是正是售后中             //已改
                tvContent.setText("等待卖家发货");
                tvStatus.setText("");
                tvRefund.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.VISIBLE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                tvCommontTime.setVisibility(View.GONE);
                tvPayTime.setText("支付时间：" + bean.getOrder().getPayTime());

                break;
            case 2://待收货   要判断是否申请了售后，是否售后成功，还是正是售后中             //已改

                tvTimeCancel.setVisibility(View.VISIBLE);
                tvContent.setText("等待买家收货");
                tvStatus.setText("");
                tvLogistics.setVisibility(View.VISIBLE);
                tvSale.setVisibility(View.VISIBLE);
                tvConfirm.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.VISIBLE);
                tvFahuoTime.setVisibility(View.VISIBLE);
                tvShouhuoTime.setVisibility(View.GONE);
                tvCommontTime.setVisibility(View.GONE);
                tvPayTime.setText("支付时间：" + bean.getOrder().getPayTime());
                tvFahuoTime.setText("发货时间：" + bean.getOrder().getShipTime());
                if (bean.getOnRefunding() > 0) {
                    tvStatus.setText(bean.getOnRefunding() + "件商品在售后");
                    tvSale.setVisibility(View.GONE);
                } else if (bean.getRefundSuccess() > 0) {
                    tvStatus.setText(bean.getOnRefunding() + "件商品售后成功");
                    tvSale.setVisibility(View.GONE);
                } else if(!TextUtils.isEmpty(bean.getWaitReceiptTime())){
                    String str = MineDateUtils.getDatePoor(MineDateUtils.stringToDate(bean.getWaitReceiptTime(), MineDateUtils.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI), MineDateUtils.getDate());
                    tvTimeCancel.setText(str + "后自动收货");
                }else {
                    tvTimeCancel.setVisibility(View.GONE);
                }


                break;
            case 3://待评价                                             //已改
                tvStatus.setText("");
                tvContent.setText("等待买家评价");
                tvCommont.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.VISIBLE);
                tvFahuoTime.setVisibility(View.VISIBLE);
                tvShouhuoTime.setVisibility(View.VISIBLE);
                tvCommontTime.setVisibility(View.GONE);
                tvPayTime.setText("支付时间：" + bean.getOrder().getPayTime());
                tvFahuoTime.setText("发货时间：" + bean.getOrder().getShipTime());
                tvShouhuoTime.setText("收货时间：");//注意，没有该字段


                break;
            case 4://交易完成  , 判断是否已经评价了                   //已改
                tvStatus.setText("");
                tvContent.setText("交易已完成");
                //未评价
                tvCommont.setVisibility(View.VISIBLE);
                //已评价
                tvDelete.setVisibility(View.VISIBLE);
                tvViewCommont.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.VISIBLE);
                tvPayTime.setVisibility(View.GONE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                tvCommontTime.setVisibility(View.GONE);
                if (!TextUtils.isEmpty(bean.getOrder().getCommentTime())) {
                    tvCommontTime.setVisibility(View.VISIBLE);
                    tvCommontTime.setText("评价时间：" + bean.getOrder().getCommentTime());
                    tvCommont.setVisibility(View.GONE);
                } else {
                    tvViewCommont.setVisibility(View.GONE);
                    tvDelete.setVisibility(View.GONE);
                }
                break;
            case -3://交易关闭  判断是否售后成功  ，是的话       //一改
                tvContent.setText("本次交易已关闭");

                // tvStatus.setText("1件商品售后成功");
                // viewLine.setVisibility(View.GONE);
                tvDelete.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.VISIBLE);
                tvPayTime.setVisibility(View.GONE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                tvCommontTime.setVisibility(View.GONE);
                tvCloseTime.setText("关闭时间：" + bean.getOrder().getCloseTime());
                if (bean.getRefundSuccess() > 0) {
                    tvStatus.setText(bean.getOnRefunding() + "件商品售后成功");
                } else {
                    tvStatus.setText("");
                }
                break;
            default:
        }

        nestView.setVisibility(View.VISIBLE);

    }


    @Override
    public void cancelOrderSu() {
        ToastUtils.showShort("取消订单成功");
        EventBus.getDefault().post(new OrderEvent());
        finish();
    }

    @Override
    public void deleteOrderSu() {
        ToastUtils.showShort("删除订单成功");
        EventBus.getDefault().post(new OrderEvent());
        finish();
    }

    @Override
    public void confirmReceiptOrderSu() {
        ToastUtils.showShort("确认收货成功");
        EventBus.getDefault().post(new OrderEvent());
        finish();
    }

    @Override
    public void cancelRefundSu() {
        ToastUtils.showShort("取消售后成功");
        EventBus.getDefault().post(new OrderEvent());
        finish();
    }


    public String convrt(long time) {
        int hours = (int) ((time) % (24 * 3600) / 3600);
        int minutes = (int) ((time) % 3600 / 60);
        return hours + "小时" + minutes + "分后自动取消订单";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
