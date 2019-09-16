package com.groundbuy.mine_model.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.MineCommentAdapter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MineCommentLisActivity extends MineBaseActivity {


    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    private MineCommentAdapter mAdapter;
    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_comment_lis;
    }

    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        List<String> mList = new ArrayList<>();
        for (int i = 0;i<5;i++)
        {
            mList.add("CXCC");
        }
        mAdapter = new MineCommentAdapter(mList);
        rvComment.setLayoutManager(new LinearLayoutManager(this));
        rvComment.setAdapter(mAdapter);
    }


}
