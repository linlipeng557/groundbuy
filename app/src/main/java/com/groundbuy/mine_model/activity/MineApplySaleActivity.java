package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.ApplyAdapter;
import com.groundbuy.mine_model.adapter.ReasonAdapter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.GridItemDecoration;
import com.groundbuy.mine_model.widgets.dialog.ApplyDialog;
import com.groundbuy.mine_model.widgets.dialog.BottomSelectDilaog;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineApplySaleActivity extends MineBaseActivity {


    @BindView(R.id.check_box)
    CheckBox checkBox;
    @BindView(R.id.iv_user)
    RoundedImageView ivUser;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.rv_apply)
    RecyclerView rvApply;
    @BindView(R.id.tv_apply)
    TextView tvApply;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.iv_down)
    ImageView ivDown;
    @BindView(R.id.ll_reason)
    LinearLayout llReason;
    @BindView(R.id.rv_reason)
    RecyclerView rvReason;
    private ApplyAdapter mAdapter;
    private BottomSelectDilaog mDialog;
    private int mTag;
    private ReasonAdapter mReasonAdapter;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_apply_sale;
    }

    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        List<String> mList = new ArrayList<>();
        mList.add("SFDSF");
        rvApply.setLayoutManager(new GridLayoutManager(this, 4));
        mAdapter = new ApplyAdapter(this, mList, 0);
        rvApply.addItemDecoration(new GridItemDecoration(SizeUtils.dp2px(7), SizeUtils.dp2px(8)));
        rvApply.setAdapter(mAdapter);
        mAdapter.setOnChooseListener(new ApplyAdapter.onChooseListener() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onAdd() {
                if (mDialog == null) {
                    mDialog = new BottomSelectDilaog(MineApplySaleActivity.this, 0);
                    mDialog.setOnSelectListener(new BottomSelectDilaog.OnSelectListener() {
                        @Override
                        public void onTop() {
                            ToastUtils.showShort("拍照");
                            mDialog.dismiss();
                        }

                        @Override
                        public void onBottom() {
                            ToastUtils.showShort("从相册选择");
                            mDialog.dismiss();
                        }
                    });
                    mDialog.showAtLocation(tvApply, Gravity.BOTTOM, 0, 0);
                } else {
                    mDialog.showAtLocation(tvApply, Gravity.BOTTOM, 0, 0);
                }
            }
        });


    }


    @OnClick({R.id.tv_apply, R.id.ll_reason})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_apply:
                ApplyDialog dialog = new ApplyDialog(this, "", " 您的售后申请已提交，\n请等待商家审核！");
                dialog.setonOkClickListener(new ApplyDialog.onOkClickListener() {
                    @Override
                    public void onClick() {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.ll_reason:
                if (mTag == 0) {
                    ivDown.setImageResource(R.mipmap.mine_sqsh_list_icon_up);
                    if (mReasonAdapter == null) {
                        List<String> mList = new ArrayList<>();
                        mList.add("发错了");
                        mList.add("质量问题");
                        mList.add("款式不一样");
                        mReasonAdapter = new ReasonAdapter(mList);
                        rvReason.setLayoutManager(new LinearLayoutManager(this));
                        rvReason.setAdapter(mReasonAdapter);
                        mReasonAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                tvReason.setText(mList.get(position));
                            }
                        });
                    }
                    rvReason.setVisibility(View.VISIBLE);
                    mTag = 1;
                } else {
                    ivDown.setImageResource(R.mipmap.mine_sqsh_list_icon_down);
                    rvReason.setVisibility(View.GONE);
                    mTag = 0;
                }
                break;
        }
    }


}
