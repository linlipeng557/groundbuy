package com.groundbuy.mine_model.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.AddressBean;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/3
 */
public class AddressAdapter extends BaseQuickAdapter<AddressBean.BaseDataBean.ListBean, BaseViewHolder> {
    public AddressAdapter(@Nullable List<AddressBean.BaseDataBean.ListBean> data) {
        super(R.layout.item_mine_address, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AddressBean.BaseDataBean.ListBean item) {
        helper.addOnClickListener(R.id.tv_del, R.id.tv_edit, R.id.iv_yes, R.id.iv_no);
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_phone, item.getMobile());
        helper.setText(R.id.tv_address, item.getProvince() + item.getCity() + item.getArea() + item.getAddress());
        if (item.getIsChoice() == 1) {
            helper.setGone(R.id.iv_yes, true);
            helper.setGone(R.id.iv_no, false);
        } else {
            helper.setGone(R.id.iv_yes, false);
            helper.setGone(R.id.iv_no, true);
        }

    }
}
