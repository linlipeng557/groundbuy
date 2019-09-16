package com.groundbuy.mine_model.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/2
 */
public class WalletAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public WalletAdapter(@Nullable List<String> data) {
        super(R.layout.item_mine_wallet, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {

    }


}
