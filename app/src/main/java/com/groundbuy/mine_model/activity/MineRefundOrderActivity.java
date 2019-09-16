package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.ImagesAdapter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.GridItemDecoration;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineRefundOrderActivity extends MineBaseActivity {
    public static final String REFUND_STATUS_1 = "status_1";//售后审核中
    public static final String REFUND_STATUS_2 = "status_2";//售后成功，，
    public static final String REFUND_STATUS_3 = "status_3";//售后被拒
    public static final String REFUND_STATUS_4 = "status_4";//申请通过  这时候要填写快递信息
    public static final String REFUND_STATUS_5 = "status_5";//申请通过后提交快递信息 ， 审核中
    public static final String REFUND_STATUS_6 = "status_6";//售后成功  ，这时候显示快递信息，不可编辑
    public static final String REFUND_STATUS_7 = "status_7";//售后被拒   这时候显示快递信息， 但是中途可能协商好了，
    public static final String REFUND_STATUS_8 = "status_8";//售后关闭
    @BindView(R.id.tv_by_deny_title)
    TextView tvByDenyTitle;
    @BindView(R.id.tv_by_deny_content)
    TextView tvByDenyContent;
    @BindView(R.id.ll_by_deny)
    LinearLayout llByDeny;
    @BindView(R.id.et_express)
    EditText etExpress;
    @BindView(R.id.tv_express)
    TextView tvExpress;
    @BindView(R.id.et_express_num)
    EditText etExpressNum;
    @BindView(R.id.tv_express_num)
    TextView tvExpressNum;
    @BindView(R.id.tv_commont)
    TextView tvCommont;
    @BindView(R.id.tv_sale_oder)
    TextView tvSaleOder;
    @BindView(R.id.tv_apply_time)
    TextView tvApplyTime;
    @BindView(R.id.tv_review_time1)
    TextView tvReviewTime1;
    @BindView(R.id.tv_submit_time)
    TextView tvSubmitTime;
    @BindView(R.id.tv_review_time2)
    TextView tvReviewTime2;
    @BindView(R.id.ll_send_express)
    LinearLayout llSendExpress;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_time_cancel)
    TextView tvTimeCancel;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.ll_cancel)
    LinearLayout llCancel;
    @BindView(R.id.tv_submit_reason_title)
    TextView tvSubmitReasonTitle;
    @BindView(R.id.tv_submit_reason_content)
    TextView tvSubmitReasonContent;
    @BindView(R.id.ll_submit_reason)
    LinearLayout llSubmitReason;
    @BindView(R.id.tv_close_time)
    TextView tvCloseTime;
    @BindView(R.id.rv_reason)
    RecyclerView rvReason;
    private String mType;
    private ImagesAdapter mAdapter;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_refund_order;
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
        mType = getIntent().getStringExtra("Type");

        switch (mType) {
            case REFUND_STATUS_1://售后审核中
                llByDeny.setVisibility(View.GONE);
                llSendExpress.setVisibility(View.GONE);
                tvCommont.setEnabled(false);
                tvReviewTime1.setVisibility(View.GONE);
                tvReviewTime2.setVisibility(View.GONE);
                tvSubmitTime.setVisibility(View.GONE);
                tvContent.setText("售后审核中");
                tvTimeCancel.setText("6天23小时后系统自动为您退款");
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_2://售后成功，，
                tvContent.setText("售后成功");
                tvTimeCancel.setText("商家已同意您的售后申请");
                llByDeny.setVisibility(View.VISIBLE);
                //通过原因
                tvByDenyTitle.setText("通过原因：");
                tvByDenyContent.setText("情况属实，同意售后！");
                //隐藏快递
                llSendExpress.setVisibility(View.GONE);
                tvCommont.setEnabled(false);
                tvReviewTime2.setVisibility(View.GONE);
                tvSubmitTime.setVisibility(View.GONE);
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_3://售后被拒

                tvContent.setText("售后被拒");
                tvTimeCancel.setText("商家已同意您的售后申请");
                llByDeny.setVisibility(View.VISIBLE);
                //通过原因
                tvByDenyTitle.setText("拒绝原因：");
                tvByDenyContent.setText("已协商成功，不走售后流程");
                //隐藏快递
                llSendExpress.setVisibility(View.GONE);
                tvCommont.setEnabled(false);
                tvReviewTime2.setVisibility(View.GONE);
                tvSubmitTime.setVisibility(View.GONE);
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_4://申请通过   这时候要填写快递信息
                tvContent.setText("申请成功");
                tvTimeCancel.setText("商家已同意您的售后申请");
                llByDeny.setVisibility(View.GONE);
                etExpress.setVisibility(View.VISIBLE);
                etExpressNum.setVisibility(View.VISIBLE);
                tvExpress.setVisibility(View.GONE);
                tvExpressNum.setVisibility(View.GONE);
                tvCommont.setEnabled(false);
                tvSubmitTime.setVisibility(View.GONE);
                tvReviewTime2.setVisibility(View.GONE);
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_5://申请通过后提交快递信息 ， 审核中  ，快递不可填
                tvContent.setText("审核中");
                tvTimeCancel.setText("商家已同意您的售后申请");
                llByDeny.setVisibility(View.VISIBLE);
                tvByDenyTitle.setText("通过原因：");
                tvByDenyContent.setText("情况属实");
                etExpress.setVisibility(View.GONE);
                etExpressNum.setVisibility(View.GONE);
                tvExpress.setVisibility(View.VISIBLE);
                tvExpressNum.setVisibility(View.VISIBLE);
                tvCommont.setVisibility(View.INVISIBLE);
                tvReviewTime2.setVisibility(View.GONE);
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_6://售后成功  ，这时候显示快递信息，不可编辑
                tvContent.setText("售后成功");
                tvTimeCancel.setText("商家已同意您的售后申请");
                llSubmitReason.setVisibility(View.VISIBLE);
                //显示一开始的原因
                tvByDenyTitle.setText("通过原因：");
                tvByDenyContent.setText("情况属实，同意售后！");
                //显示最后的原因
                tvSubmitReasonTitle.setText("通过原因：");
                tvSubmitReasonContent.setText("情况属实，同意售后！");
                llByDeny.setVisibility(View.GONE);
                etExpress.setVisibility(View.GONE);
                etExpressNum.setVisibility(View.GONE);
                tvExpress.setVisibility(View.VISIBLE);
                tvExpressNum.setVisibility(View.VISIBLE);
                tvCommont.setVisibility(View.GONE);
                tvReviewTime2.setVisibility(View.GONE);
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_7://售后被拒   这时候显示快递信息， 但是中途可能协商好了，
                tvContent.setText("售后被拒");
                tvTimeCancel.setText("商家已同意您的售后申请");
                llSubmitReason.setVisibility(View.VISIBLE);
                //显示一开始的原因
                tvByDenyTitle.setText("通过原因：");
                tvByDenyContent.setText("情况属实，同意售后！");
                //显示最后的原因
                tvSubmitReasonTitle.setText("拒绝原因：");
                tvSubmitReasonContent.setText("已协商成功，不走售后流程");
                llByDeny.setVisibility(View.GONE);
                etExpress.setVisibility(View.GONE);
                etExpressNum.setVisibility(View.GONE);
                tvExpress.setVisibility(View.VISIBLE);
                tvExpressNum.setVisibility(View.VISIBLE);
                tvCommont.setVisibility(View.GONE);
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            case REFUND_STATUS_8:
                llByDeny.setVisibility(View.GONE);
                llSendExpress.setVisibility(View.GONE);
                tvCommont.setEnabled(false);
                tvReviewTime1.setVisibility(View.GONE);
                tvReviewTime2.setVisibility(View.GONE);
                tvSubmitTime.setVisibility(View.GONE);
                tvCloseTime.setVisibility(View.VISIBLE);
                tvContent.setText("售后关闭");
                tvTimeCancel.setText("您已关闭售后详情");
                //隐藏底部按钮
                viewLine.setVisibility(View.GONE);
                llCancel.setVisibility(View.GONE);
                //Adapter tag==1 //图片不可选择
                break;
            default:
        }
        List<String> mList = new ArrayList<>();
        mList.add("FFF");
        mList.add("FFF");
        mList.add("FFF");
        mList.add("FFF");
        mAdapter = new ImagesAdapter(mList);
        rvReason.setLayoutManager(new GridLayoutManager(this, 3));
        GridItemDecoration decoration = new GridItemDecoration(SizeUtils.dp2px(14), SizeUtils.dp2px(8));
        rvReason.addItemDecoration(decoration);
        rvReason.setAdapter(mAdapter);


    }


    @OnClick(R.id.tv_cancel)
    public void onViewClicked() {
        new GeneralDialog.Builder(this).setContent("关闭售后申请，\n 每个订单只可提交一次").setLeftAndRight(new GeneralDialog.Builder.LeftAndRightAble() {
            @Override
            public void onLeftClick(GeneralDialog dialog) {
                dialog.dismiss();
            }

            @Override
            public void onRightClick(GeneralDialog dialog) {
                dialog.dismiss();
                ToastUtils.showShort("取消成功");
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
