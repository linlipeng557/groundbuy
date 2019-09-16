package com.groundbuy.mine_model.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.widgets.GridItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class MineCommentAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public MineCommentAdapter(@Nullable List<String> data) {
        super(R.layout.item_mine_comment_list, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        RecyclerView rvImage = helper.getView(R.id.rv_images);
        rvImage.setLayoutManager(new GridLayoutManager(mContext, 4));
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mList.add("VVVV");
        }
        if (rvImage.getItemDecorationCount() == 0) {
            rvImage.addItemDecoration(new GridItemDecoration( SizeUtils.dp2px(7),SizeUtils.dp2px(8)));
        }
        rvImage.setAdapter(new ImagesAdapter(mList));
    }
}
