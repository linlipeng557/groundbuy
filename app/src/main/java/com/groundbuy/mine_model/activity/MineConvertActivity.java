package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.ConvertAdapter;
import com.groundbuy.mine_model.bean.ExchangeBean;
import com.groundbuy.mine_model.mvp.contract.MineConvertContract;
import com.groundbuy.mine_model.mvp.model.MineConvertModel;
import com.groundbuy.mine_model.mvp.presenter.MineConvertPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineConvertActivity extends MineBaseActivity<MineConvertPresenter> implements MineConvertContract.IView, OnLoadMoreListener, OnRefreshListener {

    @BindView(R.id.rv_convert)
    RecyclerView rvConvert;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private ConvertAdapter mAdapter;
    private List<ExchangeBean.BaseDataBean.ListBean> mListBean = new ArrayList<>();
    private int mPage = 1;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_convert;
    }

    @Override
    protected MineConvertPresenter initPresenter() {
        return new MineConvertPresenter(this, new MineConvertModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        mAdapter = new ConvertAdapter(mListBean);
        rvConvert.setLayoutManager(new LinearLayoutManager(this));
        rvConvert.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MineConvertActivity.this, MineConvertDetailsActivity.class).putExtra("exchangeId",mListBean.get(position).getExchangeId()));
            }
        });
     //   mPresenter.exchangeList("" + mPage, "20");
        smartRefresh.setOnLoadMoreListener(this);
        smartRefresh.setOnRefreshListener(this);
        smartRefresh.autoRefresh();
    }

    @Override
    public void showDialog() {
      // showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        //dismissBaseDialog();
        if (smartRefresh.isRefreshing())
        {
            smartRefresh.finishLoadMore();
            smartRefresh.finishRefresh();
        }

    }

    @Override
    public void exchangeListSu(ExchangeBean bean) {

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


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        mPresenter.exchangeList(""+mPage, "20");
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        mPresenter.exchangeList("" + mPage, "20");
    }
}
