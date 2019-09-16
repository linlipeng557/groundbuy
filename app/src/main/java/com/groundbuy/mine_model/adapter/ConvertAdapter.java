package com.groundbuy.mine_model.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.http.RetrofitHandler;
import com.groundbuy.mine_model.bean.ExchangeBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/2
 */
public class ConvertAdapter extends BaseQuickAdapter<ExchangeBean.BaseDataBean.ListBean, BaseViewHolder> {
    public ConvertAdapter(@Nullable List<ExchangeBean.BaseDataBean.ListBean> data) {
        super(R.layout.item_mine_convert, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ExchangeBean.BaseDataBean.ListBean item) {
        if (item.getImgUrls().size() != 0) {
            Glide.with(mContext).load(RetrofitHandler.BASE_URL + item.getImgUrls().get(0)).into((RoundedImageView) helper.getView(R.id.iv_convert));
            helper.setVisible(R.id.iv_convert,true);
        } else {
            helper.setVisible(R.id.iv_convert,false);
        }

        helper.setText(R.id.tv_tit, item.getGoodsName());
        helper.setText(R.id.tv_sku, item.getNeedUB() + "UB");
        helper.setText(R.id.tv_num, "剩" + item.getStock() + "件");


    }
}
