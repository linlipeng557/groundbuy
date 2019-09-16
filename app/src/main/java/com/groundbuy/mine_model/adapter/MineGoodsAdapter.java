package com.groundbuy.mine_model.adapter;

import android.util.SparseBooleanArray;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.CollectGoodsBean;

import java.util.HashMap;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class MineGoodsAdapter extends BaseQuickAdapter<CollectGoodsBean.BaseDataBean.ListBean, BaseViewHolder> {

    private SparseBooleanArray mMap = new SparseBooleanArray();
    private boolean isBo;
    public MineGoodsAdapter( @Nullable List<CollectGoodsBean.BaseDataBean.ListBean> data) {
        super(R.layout.item_mine_goods, data);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CollectGoodsBean.BaseDataBean.ListBean item) {

        if (isBo) {
            helper.setGone(R.id.check_box, true);
        } else {
            helper.setGone(R.id.check_box, false);
        }
        CheckBox checkBox = helper.getView(R.id.check_box);
        if (!mMap.get(helper.getAdapterPosition(), false)) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mMap.put(helper.getAdapterPosition(), b);
            }
        });
    }

    public void clearMap() {
        mMap.clear();
    }

    public SparseBooleanArray getMap() {
        return mMap;
    }
    public void visibleCheck(boolean isVi) {
        isBo = isVi;
    }
    public void addMap() {
        for (int i = 0; i < mMap.size(); i++) {
            mMap.put(i, true);
        }
    }
}
