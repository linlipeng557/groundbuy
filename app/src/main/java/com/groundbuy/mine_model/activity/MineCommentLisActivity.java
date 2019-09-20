package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.MineCommentAdapter;
import com.groundbuy.mine_model.bean.MyCommentBean;
import com.groundbuy.mine_model.mvp.contract.MineCommentListContract;
import com.groundbuy.mine_model.mvp.model.MineCommentListModel;
import com.groundbuy.mine_model.mvp.presenter.MineCommentListPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineCommentLisActivity extends MineBaseActivity<MineCommentListPresenter> implements MineCommentListContract.IView {


    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private MineCommentAdapter mAdapter;
    private int mPage = 1;
    private List<MyCommentBean.BaseDataBean.ListBean> mListBean = new ArrayList<>();

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_comment_lis;
    }

    @Override
    protected MineCommentListPresenter initPresenter() {
        return new MineCommentListPresenter(this, new MineCommentListModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);

        mAdapter = new MineCommentAdapter(mListBean);
        rvComment.setLayoutManager(new LinearLayoutManager(this));
        rvComment.setAdapter(mAdapter);
        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                mPresenter.getCommentList("" + mPage, "20");
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPage = 1;
                mPresenter.getCommentList("" + mPage, "20");
            }
        });
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {
        if (smartRefresh.isLoading()) {
            smartRefresh.finishLoadMore();
            smartRefresh.finishRefresh();
        }

    }

    @Override
    public void getCommentListSu(MyCommentBean bean) {
        smartRefresh.finishLoadMore();
        smartRefresh.finishRefresh();
        if (bean == null || bean.getBaseData() == null || bean.getBaseData().getList() == null || bean.getBaseData().getList().size() == 0) {
            // tvHint.setText("暂无更多数据");
            smartRefresh.setEnableLoadMore(false);
            return;
        } else {
            smartRefresh.setVisibility(View.VISIBLE);
        }

        if (bean.getBaseData().isFirstPage()) {
            mListBean.clear();
        }
        mListBean.addAll(bean.getBaseData().getList());
        if (bean.getBaseData().isLastPage()) {
            smartRefresh.setEnableLoadMore(false);
        } else {
            smartRefresh.setEnableLoadMore(true);
        }
        mAdapter.notifyDataSetChanged();

    }
}
