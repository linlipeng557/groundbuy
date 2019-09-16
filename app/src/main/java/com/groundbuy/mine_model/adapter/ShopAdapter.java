package com.groundbuy.mine_model.adapter;

import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;
import com.groundbuy.mine_model.bean.CollectShopBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/2
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopVH> {


    private Context mContext;
    private List<CollectShopBean.BaseDataBean.ListBean> mList;
    private SparseBooleanArray mMap = new SparseBooleanArray();
    private boolean isVisible;

    public ShopAdapter(Context context, List<CollectShopBean.BaseDataBean.ListBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ShopVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopVH holder, int position) {
        holder.checkBox.setOnCheckedChangeListener(null);
        if (isVisible) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(View.GONE);
        }

        if (mMap.get(position,false)) {
            holder.checkBox.setChecked(true);
        } else {
            mMap.put(position, false);
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChoose) {

                if (isChoose) {
                    for (int i = 0; i < mList.size(); i++) {
                        if (!mMap.get(i,false)) {
                            if (listener != null) {
                                listener.isAdd(false);
                                break;
                            }
                        } else if (i == mList.size() - 1) {
                            if (listener != null) {
                                listener.isAdd(true);
                            }
                        }
                    }
                } else {
                    if (listener != null) {
                        listener.isAdd(false);
                    }
                }
                mMap.put(position, isChoose);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }




    public static class ShopVH extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        RoundedImageView ivUser;
        TextView tvNick;

        public ShopVH(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.check_box);
            ivUser = itemView.findViewById(R.id.iv_user);
            tvNick = itemView.findViewById(R.id.tv_nick);
        }
    }

    public void addMap() {
        for (int i = 0; i < mList.size(); i++) {
            mMap.put(i, true);
        }
    }

    public void checkVisible(boolean b) {
        isVisible = b;
    }

    public void clearMap() {
        for (int i = 0; i < mList.size(); i++) {
            mMap.put(i, false);
        }
    }

    public SparseBooleanArray getMap() {
        return mMap;
    }

    public interface CheckListener {
        void isAdd(boolean b);
    }

    private CheckListener listener;

    public void setOnCheckListener(CheckListener listener) {
        this.listener = listener;
    }
}