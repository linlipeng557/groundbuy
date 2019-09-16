package com.groundbuy.mine_model.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/5
 */
public class LogisticsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mList;

    public LogisticsAdapter(List<String> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new OneVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_logistics_one, parent, false));
        } else {
            return new LogisticsVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_logistics, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            if (mList.size() == 1) {
                OneVH oneVH = (OneVH) holder;
                oneVH.tvOneDate.setText("昨天");
                oneVH.tvOneDate.setEnabled(true);
                oneVH.tvOneView.setText("下");
                oneVH.tvOneView.setEnabled(false);
                oneVH.tvOneStatus.setText("您已下单");
                oneVH.tvOneTime.setText("11:00");
                oneVH.tvOneTime.setEnabled(true);

            } else {
                OneVH oneVH = (OneVH) holder;
                oneVH.tvOneDate.setText("昨天");
                oneVH.tvOneDate.setEnabled(false);
                oneVH.tvOneView.setText("下");
                oneVH.tvOneView.setEnabled(false);
                oneVH.tvOneStatus.setText("您已下单");
                oneVH.tvOneTime.setText("11:00");
                oneVH.tvOneTime.setEnabled(false);
            }


        } else {
            if (position == 0) { //最前的应该要选中
                LogisticsVH logisticsVH = (LogisticsVH) holder;
                logisticsVH.tvDate.setText("今天");
                logisticsVH.tvDate.setEnabled(true);
                logisticsVH.tvView.setText("收");
                logisticsVH.tvView.setEnabled(true);
                logisticsVH.tvContent.setText("广东省广州市海珠区 琶洲街道  鱼珠坑田小区 ");
                logisticsVH.tvStatus.setText("已签收");
                logisticsVH.tvTime.setText("8:30");
                logisticsVH.tvTime.setEnabled(true);


            } else if (position == 1) {
                LogisticsVH logisticsVH = (LogisticsVH) holder;
                logisticsVH.tvDate.setText("今天");
                logisticsVH.tvDate.setEnabled(false);
                logisticsVH.tvView.setText("配");
                logisticsVH.tvView.setEnabled(false);
                logisticsVH.tvContent.setText("[收货地址]广东省广州市海珠区 琶洲街道 新港东路1000号琶洲保利世贸C座西塔2205室");
                logisticsVH.tvStatus.setText("配送中");
                logisticsVH.tvTime.setText("8:00");
                logisticsVH.tvTime.setEnabled(false);

            } else if (position == 2) {

                LogisticsVH logisticsVH = (LogisticsVH) holder;
                logisticsVH.tvDate.setText("昨天");
                logisticsVH.tvDate.setEnabled(false);
                logisticsVH.tvView.setText("运");
                logisticsVH.tvView.setEnabled(false);
                logisticsVH.tvView.setEnabled(false);
                logisticsVH.tvContent.setText(" 广东省广州市海珠区 琶洲街道 ");
                logisticsVH.tvStatus.setText("运输中");
                logisticsVH.tvTime.setText("19:00");
                logisticsVH.tvTime.setEnabled(false);

            } else if (position == 3) {
                LogisticsVH logisticsVH = (LogisticsVH) holder;
                logisticsVH.tvDate.setText("昨天");
                logisticsVH.tvDate.setEnabled(false);
                logisticsVH.tvView.setText("发");
                logisticsVH.tvView.setEnabled(false);
                logisticsVH.tvStatus.setText("广州小跑店铺已发货 ");
                logisticsVH.tvStatus.setText("已发货");
                logisticsVH.tvTime.setText("14:00");
                logisticsVH.tvTime.setEnabled(false);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size() == 0) {
            return 0;
        } else if (mList.size() == position + 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public static class OneVH extends RecyclerView.ViewHolder {
        private TextView tvOneDate;
        private TextView tvOneTime;
        private  LinearLayout llOneDate;
        private   TextView tvOneView;
        private   RelativeLayout rlOneTag;
        private   TextView tvOneStatus;

        public OneVH(@NonNull View itemView) {
            super(itemView);
            tvOneDate = itemView.findViewById(R.id.tv_one_date);
            tvOneTime = itemView.findViewById(R.id.tv_one_time);
            llOneDate = itemView.findViewById(R.id.ll_one_date);
            tvOneView = itemView.findViewById(R.id.tv_one_view);
            rlOneTag = itemView.findViewById(R.id.rl_one_tag);
            tvOneStatus = itemView.findViewById(R.id.tv_one_status);
        }
    }

    public static class LogisticsVH extends RecyclerView.ViewHolder {
        private   TextView tvDate;
        private    TextView tvTime;
        private      LinearLayout llDate;
        private   TextView tvView;
        private       RelativeLayout rlTag;
    private     TextView tvStatus;
        private     TextView tvContent;
        public LogisticsVH(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTime = itemView.findViewById(R.id.tv_time);
            llDate = itemView.findViewById(R.id.ll_date);
            tvView = itemView.findViewById(R.id.tv_view);
            rlTag = itemView.findViewById(R.id.rl_tag);
            tvStatus = itemView.findViewById(R.id.tv_status);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
