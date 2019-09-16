package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.ApplyAdapter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.GridItemDecoration;
import com.groundbuy.mine_model.widgets.dialog.BottomSelectDilaog;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineCommontOrderActivity extends MineBaseActivity {

    @BindView(R.id.rv_apply)
    RecyclerView rvApply;
    @BindView(R.id.et_service)
    EditText etService;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.iv_user)
    RoundedImageView ivUser;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_apply)
    TextView tvApply;
    private ApplyAdapter mAdapter;
    private BottomSelectDilaog mDialog;
    private String mType;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_commont_order;
    }

    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mType = getIntent().getStringExtra("Type");
        List<String> mList = new ArrayList<>();
        mList.add("SFDSF");
        mList.add("SFDSF");
        mList.add("SFDSF");
        rvApply.setLayoutManager(new GridLayoutManager(this, 4));
        GridItemDecoration decoration = new GridItemDecoration(SizeUtils.dp2px(7), SizeUtils.dp2px(8));
        rvApply.addItemDecoration(decoration);
        if ("GO_COMMONT".equals(mType)) {
            titleBar.setCenterTitle("评价订单");
            mAdapter = new ApplyAdapter(this, mList, 0);
            rvApply.setAdapter(mAdapter);
            mAdapter.setOnChooseListener(new ApplyAdapter.onChooseListener() {
                @Override
                public void onClick(int position) {

                }

                @Override
                public void onAdd() {
                    if (mDialog == null) {
                        mDialog = new BottomSelectDilaog(MineCommontOrderActivity.this, 0);
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
                        mDialog.showAtLocation(rvApply, Gravity.BOTTOM, 0, 0);
                    } else {
                        mDialog.showAtLocation(rvApply, Gravity.BOTTOM, 0, 0);
                    }
                }
            });
        } else {
            mAdapter = new ApplyAdapter(this, mList, 1);
            rvApply.setAdapter(mAdapter);
            titleBar.setCenterTitle("查看评价");
            etContent.setEnabled(false);
            etContent.setFocusable(false);
            etContent.setKeyListener(null);
            etService.setEnabled(false);
            etService.setFocusable(false);
            etService.setKeyListener(null);
            tvApply.setVisibility(View.GONE);
            mAdapter.setOnChooseListener(new ApplyAdapter.onChooseListener() {
                @Override
                public void onClick(int position) {

                }

                @Override
                public void onAdd() {

                }
            });
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
