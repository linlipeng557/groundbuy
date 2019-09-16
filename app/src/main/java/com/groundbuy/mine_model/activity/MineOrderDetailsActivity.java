package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineOrderDetailsActivity extends MineBaseActivity {
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
    @BindView(R.id.tv_hone)
    TextView tvHone;
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
    private int mType;
    public static final int M_ORDER_STATUS_0 = 0;//待付款
    public static final int M_ORDER_STATUS_1 = 1;//待发货
    public static final int M_ORDER_STATUS_2 = 2;//待收货
    public static final int M_ORDER_STATUS_3 = 3;//待评价
    public static final int M_ORDER_STATUS_4 = 4;//交易完成
    public static final int M_ORDER_STATUS_5 = 5;//交易关闭

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_order_details;
    }
    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }


    @Override
    public boolean statusBarLightMode() {
        return false;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mType = getIntent().getIntExtra("Type", 0);
        tvTimeCancel.setVisibility(View.GONE);

        switch (mType) {
            case M_ORDER_STATUS_0:///待付款
                tvContent.setText("买家未付款");
                tvStatus.setText("");
                tvTimeCancel.setVisibility(View.VISIBLE);
                tvTimeCancel.setText("5小时23分后关闭订单");
                tvCancel.setVisibility(View.VISIBLE);
                tvPay.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCreateTime.setText("下单时间");
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.GONE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                break;
            case M_ORDER_STATUS_1://待发货，，要判断是否申请了售后，是否售后成功，还是正是售后中
                tvContent.setText("等待卖家发货");
                tvStatus.setText("");
                //    tvStatus.setText("1件商品售后成功");
                //    tvStatus.setText("1件商品正在售后中");
                tvRefund.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.VISIBLE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                break;
            case M_ORDER_STATUS_2://待收货   要判断是否申请了售后，是否售后成功，还是正是售后中
                tvTimeCancel.setText("12天2小时22分后自动收货");
                tvTimeCancel.setVisibility(View.VISIBLE);
                tvContent.setText("等待买家收货");
                tvStatus.setText("");
                //    tvStatus.setText("1件商品售后成功");
                //    tvStatus.setText("1件商品正在售后中");
                tvLogistics.setVisibility(View.VISIBLE);
                tvSale.setVisibility(View.VISIBLE);
                //  tvSale.setVisibility(View.GONE);  申请售后的时候隐藏
                tvConfirm.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.VISIBLE);
                tvFahuoTime.setVisibility(View.VISIBLE);
                tvShouhuoTime.setVisibility(View.GONE);
                break;
            case M_ORDER_STATUS_3://待评价
                tvStatus.setText("");
                tvContent.setText("等待买家评价");
                tvCommont.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.GONE);
                tvPayTime.setVisibility(View.VISIBLE);
                tvFahuoTime.setVisibility(View.VISIBLE);
                tvShouhuoTime.setVisibility(View.VISIBLE);
                break;
            case M_ORDER_STATUS_4://交易完成  , 判断是否已经评价了
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
                break;
            case M_ORDER_STATUS_5://交易关闭  判断是否售后成功  ，是的话
                tvContent.setText("本次交易已关闭");
                tvStatus.setText("已售后");
                // tvStatus.setText("1件商品售后成功");
                // viewLine.setVisibility(View.GONE);
                tvDelete.setVisibility(View.VISIBLE);
                tvOrder.setVisibility(View.VISIBLE);
                tvCreateTime.setVisibility(View.VISIBLE);
                tvCloseTime.setVisibility(View.VISIBLE);
                tvPayTime.setVisibility(View.GONE);
                tvFahuoTime.setVisibility(View.GONE);
                tvShouhuoTime.setVisibility(View.GONE);
                break;
            default:
        }
    }


    @OnClick({R.id.tv_name, R.id.tv_logistics, R.id.tv_sale, R.id.tv_confirm, R.id.tv_delete, R.id.tv_cancel, R.id.tv_pay, R.id.tv_refund, R.id.tv_commont, R.id.tv_view_commont})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_name:
                break;
            case R.id.tv_logistics:
                break;
            case R.id.tv_sale:
                dialogShow(M_Order_Dialog_13);
                break;
            case R.id.tv_confirm:
                // dialogShow(M_Order_Dialog_9);
                dialogShow(M_Order_Dialog_10);
                break;
            case R.id.tv_delete:
                dialogShow(M_Order_Dialog_11);
                break;
            case R.id.tv_cancel:
                dialogShow(M_Order_Dialog_12);
                break;
            case R.id.tv_pay:
                break;
            case R.id.tv_refund:
                dialogShow(M_Order_Dialog_13);
                break;
            case R.id.tv_commont:
                startActivity(new Intent(this, MineCommontOrderActivity.class).putExtra("Type","GO_COMMONT"));
                break;
            case R.id.tv_view_commont:
                startActivity(new Intent(this, MineCommontOrderActivity.class).putExtra("Type","VIEW_COMMONT"));
                break;

        }
    }

    public void dialogShow(int tag) {
        String mContent = null;
        String mToast = null;
        String mSale = null, mService = null;
        switch (tag) {
            case M_Order_Dialog_9:
                mContent = "请确认收到该宝贝！";
                mToast = "收货成功";
                break;
            case M_Order_Dialog_10:
                mContent = "您正在走售后流程，\n收货后将关闭售后单，您确定吗？";
                mToast = "收货成功";
                break;
            case M_Order_Dialog_11:
                mContent = "确定要删除该订单？";
                mToast = "删除成功";
                break;
            case M_Order_Dialog_12:
                mContent = "确定要取消该订单？";
                mToast = "取消成功";
                break;
            case M_Order_Dialog_13:
                mContent = "只可申请一次售后，\n确定要继续走售后吗？";
                mToast = "进入售后";
                mSale = "继续售后";
                mService = "找客服聊聊";
                break;
            default:
        }
        String finalMToast = mToast;
        new GeneralDialog.Builder(this).setContent(mContent).setLeftAndRight(mSale, mService, new GeneralDialog.Builder.LeftAndRightAble() {
            @Override
            public void onLeftClick(GeneralDialog dialog) {
                dialog.dismiss();
                if (tag == M_Order_Dialog_13) {
                    ToastUtils.showShort(finalMToast);
                    startActivity(new Intent(MineOrderDetailsActivity.this, MineApplySaleActivity.class));
                }
            }

            @Override
            public void onRightClick(GeneralDialog dialog) {
                if (tag != M_Order_Dialog_13) {
                    ToastUtils.showShort(finalMToast);
                }

                dialog.dismiss();
            }
        }).create();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
