package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.groundbuy.mine_model.mvp.contract.MineApplyContract;
import com.groundbuy.mine_model.mvp.model.MineApplyModel;
import com.groundbuy.mine_model.mvp.presenter.MineApplyPresenter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.utils.UCropUtil;
import com.groundbuy.mine_model.widgets.GridItemDecoration;
import com.groundbuy.mine_model.widgets.dialog.ApplyDialog;
import com.groundbuy.mine_model.widgets.dialog.BottomSelectDilaog;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhihu.matisse.Matisse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineApplySaleActivity extends MineBaseActivity<MineApplyPresenter> implements MineApplyContract.IView {


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
    private List<Uri> mList = new ArrayList<>();

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_apply_sale;
    }

    @Override
    protected MineApplyPresenter initPresenter() {
        return new MineApplyPresenter(this, new MineApplyModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mAdapter = new ApplyAdapter(this, mList, 0);
        rvApply.setLayoutManager(new GridLayoutManager(this, 4));
        rvApply.addItemDecoration(new GridItemDecoration(SizeUtils.dp2px(7), SizeUtils.dp2px(8)));
        rvApply.setAdapter(mAdapter);
        mAdapter.setOnChooseListener(new ApplyAdapter.onChooseListener() {

            @Override
            public void onDel(int position) {
                mList.remove(position);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdd() {
                if (mDialog == null) {
                    mDialog = new BottomSelectDilaog(MineApplySaleActivity.this, 0);
                    mDialog.setOnSelectListener(new BottomSelectDilaog.OnSelectListener() {
                        @Override
                        public void onTop() {
                            UCropUtil.handlepicture(this_());

                        }

                        @Override
                        public void onBottom() {
                            UCropUtil.openAlbum(this_(), 8);

                        }
                    });
                    mDialog.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mDialog.changeBg(1f);
                        }
                    });
                    mDialog.showAtLocation(tvApply, Gravity.BOTTOM, 0, 0);
                } else {
                    mDialog.showAtLocation(tvApply, Gravity.BOTTOM, 0, 0);
                }
            }
        });


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case UCropUtil.TAKE_PHOTO:
                    mList.add(UCropUtil.imageUri);
                    mAdapter.notifyDataSetChanged();
                    break;
                case UCropUtil.SUCCESS_CODE:
                    mList.addAll(Matisse.obtainResult(data));
                    mAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
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
                        mList.add("未收到货");
                        mList.add("已收到货");
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


    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void orderRefund() {

    }
}
