package com.groundbuy.mine_model.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.groundbuy.R;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;
import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class MineGoodsAdapter extends RecyclerView.Adapter<MineGoodsAdapter.GoodsVH> {


    private Context mContext;
    private List<CollectGoodsBean.BaseDataBean.ListBean> mList;
    private SparseBooleanArray mMap = new SparseBooleanArray();
    private boolean isVisible;

    public MineGoodsAdapter(Context context, List<CollectGoodsBean.BaseDataBean.ListBean> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public GoodsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GoodsVH(LayoutInflater.from(mContext).inflate(R.layout.item_mine_goods, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsVH holder, int position) {
        holder.checkBox.setOnCheckedChangeListener(null);
        if (isVisible) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(View.GONE);
        }

        if (mMap.get(position, false)) {
            holder.checkBox.setChecked(true);
        } else {
            mMap.put(position, false);
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChoose) {
                mMap.put(position, isChoose);
                if (isChoose) {
                    for (int i = 0; i < mList.size(); i++) {
                        if (!mMap.get(i, false)) {
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

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class GoodsVH extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        RoundedImageView ivUser;
        TextView tvNick;

        public GoodsVH(@NonNull View itemView) {
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

    private ShopAdapter.CheckListener listener;

    public void setOnCheckListener(ShopAdapter.CheckListener listener) {
        this.listener = listener;
    }
}
