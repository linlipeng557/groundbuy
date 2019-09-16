package com.groundbuy.mine_model.widgets;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/5
 */
public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;
    private int mBottomSpace;
    public GridItemDecoration(  int space,int bottomSpace) {

        this.mSpace = space;
        this.mBottomSpace  = bottomSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position != -1) {
            outRect.set(mSpace/2, 0, mSpace/2, mBottomSpace);
        }

    }
}
