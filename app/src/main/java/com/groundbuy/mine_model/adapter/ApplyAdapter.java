package com.groundbuy.mine_model.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.groundbuy.R;

import java.util.List;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/4
 */
public class ApplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Uri> mList;
    private List<String> mList1;
    private Context mContext;
    private int mTag;

    public ApplyAdapter(Context context, List<Uri> list, int tag) {
        this.mContext = context;
        this.mList = list;
        this.mTag = tag;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mTag == 0) {
            if (viewType == 0) {
                return new AddImageVH(LayoutInflater.from(mContext).inflate(R.layout.item_mine_add_image, parent, false));
            } else {
                return new ApplyImageVH(LayoutInflater.from(mContext).inflate(R.layout.item_apply_image, parent, false));
            }
        } else {
            return new ApplyImageVH(LayoutInflater.from(mContext).inflate(R.layout.item_apply_image, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (mTag == 0) {

            if (getItemViewType(position) == 0) {
                AddImageVH addImageVH = (AddImageVH) holder;
                addImageVH.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (listener != null) {
                            listener.onAdd();
                        }
                    }
                });

            } else {
                ApplyImageVH applyImageVH = (ApplyImageVH) holder;
                Glide.with(mContext).load(mList.get(position)).into(applyImageVH.ivImg);
                applyImageVH.ivClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            listener.onDel(position);
                        }
                    }
                });

            }
        } else {
            ApplyImageVH applyImageVH = (ApplyImageVH) holder;
            applyImageVH.ivClose.setVisibility(View.GONE);
            Glide.with(mContext).load(mList.get(position)).into(applyImageVH.ivImg);
            applyImageVH.ivClose.setVisibility(View.GONE);
        }

    }


    @Override
    public int getItemCount() {
        if (mTag == 0) {
            return mList.size() + 1;
        } else {
            return mList.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (mTag == 0) {
            if (mList.size() == 0) {
                return 0;
            } else if (position < mList.size()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return position;
        }

    }

    public static class ApplyImageVH extends RecyclerView.ViewHolder {
        private ImageView ivImg;

        private ImageView ivClose;

        public ApplyImageVH(@NonNull View itemView) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.iv_img);
            ivClose = itemView.findViewById(R.id.iv_close);
        }
    }

    public static class AddImageVH extends RecyclerView.ViewHolder {

        public AddImageVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface onChooseListener {
        void onDel(int position);

        void onAdd();
    }

    private onChooseListener listener;

    public void setOnChooseListener(onChooseListener listener) {
        this.listener = listener;
    }
}
