package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.PugAdapter;
import com.groundbuy.mine_model.bean.HistoryListBean;
import com.groundbuy.mine_model.mvp.contract.MineHistoryPugContract;
import com.groundbuy.mine_model.mvp.model.MineHistoryPugModel;
import com.groundbuy.mine_model.mvp.presenter.MineHistoryPugPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineHistoryPugActivity extends MineBaseActivity<MineHistoryPugPresenter> implements MineHistoryPugContract.IView, OnLoadMoreListener, OnRefreshListener {


    @BindView(R.id.rv_pug)
    RecyclerView rvPug;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private PugAdapter mAdapter;
    private List<HistoryListBean.BaseDataBean.ListBean> mListBean = new ArrayList<>();
    private int mPage = 1;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_history_pug;
    }


    @Override
    protected MineHistoryPugPresenter initPresenter() {
        return new MineHistoryPugPresenter(this, new MineHistoryPugModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mAdapter = new PugAdapter(mListBean);
        rvPug.setLayoutManager(new LinearLayoutManager(this));
        rvPug.setAdapter(mAdapter);
        smartRefresh.setOnLoadMoreListener(this);
        smartRefresh.setOnRefreshListener(this);
        smartRefresh.autoRefresh();
    }


    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
        if (smartRefresh.isRefreshing() || smartRefresh.isLoading()) {
            smartRefresh.finishLoadMore();
            smartRefresh.finishRefresh();
        }
    }

    @Override
    public void historyListSu(HistoryListBean bean) {

        if (bean == null || bean.getBaseData() == null || bean.getBaseData().getList() == null || bean.getBaseData().getList().size() == 0) {
            // tvHint.setText("暂无更多数据");
            smartRefresh.setEnableLoadMore(false);
            return;
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


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        mPresenter.historyList("" + mPage, "20");
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        mPresenter.historyList("" + mPage, "20");
    }


}
