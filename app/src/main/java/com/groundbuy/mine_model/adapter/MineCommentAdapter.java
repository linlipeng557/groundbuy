package com.groundbuy.mine_model.adapter;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.MyCommentBean;
import com.groundbuy.mine_model.widgets.GridItemDecoration;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class MineCommentAdapter extends BaseQuickAdapter<MyCommentBean.BaseDataBean.ListBean, BaseViewHolder> {
    public MineCommentAdapter(@Nullable List<MyCommentBean.BaseDataBean.ListBean> data) {
        super(R.layout.item_mine_comment_list, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MyCommentBean.BaseDataBean.ListBean item) {
        Glide.with(mContext).load(item.getPortrait()).into((RoundedImageView) helper.getView(R.id.iv_user));
        helper.setText(R.id.tv_comment, item.getContent());
        helper.setText(R.id.tv_time, item.getCreateTime());

        if (item.getGoodsImgs() != null || item.getGoodsImgs().size() != 0) {

            Glide.with(mContext).load(item.getPortrait()).into((ImageView) helper.getView(R.id.iv_goods));
        } else {
            Glide.with(mContext).load("").into((ImageView) helper.getView(R.id.iv_goods));
        }
        helper.setText(R.id.tv_goods_title, item.getGoodsName());
        helper.setText(R.id.tv_price, "￥" + item.getDiscountPrice());
        TextView oldPriceTv = helper.getView(R.id.tv_old_price);
        oldPriceTv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        oldPriceTv.setText("￥" + item.getPrice());

        RecyclerView rvImage = helper.getView(R.id.rv_images);
        rvImage.setLayoutManager(new GridLayoutManager(mContext, 4));

        if (rvImage.getItemDecorationCount() == 0) {
            rvImage.addItemDecoration(new GridItemDecoration(SizeUtils.dp2px(7), SizeUtils.dp2px(8)));
        }
        rvImage.setAdapter(new ImagesAdapter(item.getCommentImgs()));
    }
}
