package com.groundbuy.mine_model.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class ImagesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ImagesAdapter(@Nullable List<String> data) {
        super(R.layout.item_mine_imags, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.iv_images));
    }
}
