package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.ApplyAdapter;
import com.groundbuy.mine_model.adapter.ImagesAdapter;
import com.groundbuy.mine_model.bean.OrderCommontBean;
import com.groundbuy.mine_model.bean.OrderContentBean;
import com.groundbuy.mine_model.bean.PictureBean;
import com.groundbuy.mine_model.event.OrderEvent;
import com.groundbuy.mine_model.mvp.contract.MineCommontOrderContract;
import com.groundbuy.mine_model.mvp.model.MineCommontOrderModel;
import com.groundbuy.mine_model.mvp.presenter.MineCommontOrderPresenter;
import com.groundbuy.mine_model.utils.FileUtil;
import com.groundbuy.mine_model.utils.UCropUtil;
import com.groundbuy.mine_model.widgets.GridItemDecoration;
import com.groundbuy.mine_model.widgets.dialog.BottomSelectDilaog;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhihu.matisse.Matisse;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineCommontOrderActivity extends MineBaseActivity<MineCommontOrderPresenter> implements MineCommontOrderContract.IView {

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
    @BindView(R.id.tv_tit)
    TextView tvTit;
    @BindView(R.id.tv_sku)
    TextView tvSku;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_size_count)
    TextView tvSizeCount;
    private ApplyAdapter mAdapter;
    private BottomSelectDilaog mDialog;
    private String mType;
    private List<Uri> mList = new ArrayList<>();
    private OrderContentBean mBean;
    private List<File> mFileList = new ArrayList<>();
    private String mImgs = null;


    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_commont_order;
    }

    @Override
    protected MineCommontOrderPresenter initPresenter() {
        return new MineCommontOrderPresenter(this, new MineCommontOrderModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mType = getIntent().getStringExtra("Type");
        rvApply.setLayoutManager(new GridLayoutManager(this, 4));
        GridItemDecoration decoration = new GridItemDecoration(SizeUtils.dp2px(3), SizeUtils.dp2px(4));
        rvApply.addItemDecoration(decoration);
        if ("GO_COMMONT".equals(mType)) {
            mBean = (OrderContentBean) getIntent().getSerializableExtra("bean");

            tvShopName.setText(mBean.getShopName());
            tvNum.setText("x" + mBean.getAmount());
            tvPrice.setText("￥" + mBean.getDiscountPrice());
            tvOldPrice.setText("￥" + mBean.getPrice());
            tvSku.setText(mBean.getStockSpecs());
            tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            if (mBean.getGoodsImgs() == null || mBean.getGoodsImgs().size() == 0) {
                Glide.with(this_()).load("").into(ivUser);
            } else {
                Glide.with(this_()).load(mBean.getGoodsImgs().get(0)).into(ivUser);
            }

            titleBar.setCenterTitle("评价订单");
            mAdapter = new ApplyAdapter(this, mList, 0);
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
                        mDialog = new BottomSelectDilaog(MineCommontOrderActivity.this, 0);
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
                        mDialog.showAtLocation(rvApply, Gravity.BOTTOM, 0, 0);
                    } else {
                        mDialog.showAtLocation(rvApply, Gravity.BOTTOM, 0, 0);
                    }
                }
            });
            etService.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.length() == 2) {
                        if (Integer.parseInt(editable.toString().trim()) > 10) {
                            etService.setText("10");
                            etService.setSelection(editable.length());
                            ToastUtils.showShort("满分十分");
                        }
                    }
                }
            });

        } else {
            String orderNumber = getIntent().getStringExtra("orderNumber");

            titleBar.setCenterTitle("查看评价");
            etContent.setEnabled(false);
            etContent.setFocusable(false);
            etContent.setKeyListener(null);
            etService.setEnabled(false);
            etService.setFocusable(false);
            etService.setKeyListener(null);
            tvApply.setVisibility(View.GONE);
            mPresenter.commentDetail(orderNumber);

        }

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

    public void luBanCompress() {
        for (int i = 0; i < mList.size(); i++) {
            File fileByUri = FileUtil.uriToFile(mList.get(i), this);
            mFileList.add(fileByUri);
            int finalI = i;
//            Luban.with(this)
//                    .load(fileByUri)
//                    .ignoreBy(100)
//                    .filter(new CompressionPredicate() {
//                        @Override
//                        public boolean apply(String path) {
//                            return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
//                        }
//                    })
//                    .setCompressListener(new OnCompressListener() {
//                        @Override
//                        public void onStart() {
//                        }
//
//                        @Override
//                        public void onSuccess(File file) {
//                            mFileList.add(finalI,file);
//                            if (mFileList.size()==3)
//                            {
//                                Glide.with(this_()).load(mFileList.get(1)).into(ivUser);
//                            }
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                        }
//                    }).launch();
        }

    }


    @OnClick(R.id.tv_apply)
    public void onViewClicked() {
        if (TextUtils.isEmpty(etService.getText().toString().trim())) {
            ToastUtils.showShort("请填写评分");
        } else if (TextUtils.isEmpty(etContent.getText().toString().trim())) {
            ToastUtils.showShort("请填写评价内容");
        } else if (mList.size() == 0) {
            mPresenter.commentGoods(mBean.getOrderNumber(), etContent.getText().toString().trim(), mImgs, etService.getText().toString());
        } else {
            mFileList.clear();
            luBanCompress();
            mPresenter.picture(mFileList);

        }
    }

    @Override
    public void pictureSu(PictureBean bean) {
        for (int i = 0; i < bean.getBaseData().size(); i++) {
            if (i == 0) {
                mImgs = bean.getBaseData().get(i);
            } else {
                mImgs = "," + bean.getBaseData().get(i);
            }
        }
        mPresenter.commentGoods(mBean.getOrderNumber(), etContent.getText().toString().trim(), mImgs, etService.getText().toString());
    }

    @Override
    public void commentGoodsSu() {
        ToastUtils.showShort("提交评价成功");
        ActivityUtils.finishActivity(MineOrderDetailsActivity.class);
        EventBus.getDefault().post(new OrderEvent());
        finish();
    }

    @Override
    public void commentDetailSu(OrderCommontBean bean) {
        tvShopName.setText(bean.getBaseData().getShopName());
        tvNum.setText("x" + bean.getBaseData().getAmount());
        tvPrice.setText("￥" + bean.getBaseData().getDiscountPrice());
        tvOldPrice.setText("￥" + bean.getBaseData().getPrice());
        tvSku.setText(bean.getBaseData().getStockSpecs());
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        String[] goodsImgs = bean.getBaseData().getGoodsImgs().split(",");
        if (goodsImgs.length == 0) {
            Glide.with(this_()).load("").into(ivUser);
        } else {
            Glide.with(this_()).load(goodsImgs[0]).into(ivUser);
        }
        if (!TextUtils.isEmpty(bean.getBaseData().getCommentImgs())) {
            String[] commontImgs = bean.getBaseData().getCommentImgs().split(",");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < commontImgs.length; i++) {
                list.add(commontImgs[i]);
            }
            rvApply.setAdapter(new ImagesAdapter(list));
        }


        etService.setText("" + bean.getBaseData().getScore());
        etContent.setText(bean.getBaseData().getContent());

    }

    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
    }


}
