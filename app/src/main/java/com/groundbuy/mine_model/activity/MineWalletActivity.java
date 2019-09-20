package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.WalletAdapter;
import com.groundbuy.mine_model.bean.RevenueListBean;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.event.UserInfoEvent;
import com.groundbuy.mine_model.mvp.contract.MineWalletContract;
import com.groundbuy.mine_model.mvp.model.MineWalletModel;
import com.groundbuy.mine_model.mvp.presenter.MineWalletPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineWalletActivity extends MineBaseActivity<MineWalletPresenter> implements MineWalletContract.IView {

    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_select)
    TextView tvSelect;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.rv_details)
    RecyclerView rvDetails;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_income)
    TextView tvIncome;
    @BindView(R.id.tv_expenditure)
    TextView tvExpenditure;
    @BindView(R.id.ll_type)
    LinearLayout llType;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private WalletAdapter mAdapter;
    private String mType = "0";
    private int mPage = 1;
    private List<RevenueListBean.BaseDataBean.ListBean> mListBean = new ArrayList<>();

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_wallet;
    }


    @Override
    public boolean statusBarLightMode() {
        return false;
    }

    @Override
    protected MineWalletPresenter initPresenter() {
        return new MineWalletPresenter(this, new MineWalletModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        EventBus.getDefault().register(this);
        tvMoney.setText("￥" + BaseApplication.getUserBean().getBaseData().getMoney());


        mAdapter = new WalletAdapter(mListBean);
        rvDetails.setLayoutManager(new LinearLayoutManager(this));
        rvDetails.setAdapter(mAdapter);

        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                mPresenter.revenueList(mType, mPage + "", "20");
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPage = 1;
                mPresenter.revenueList(mType, mPage + "", "20");
            }
        });
        smartRefresh.autoRefresh();
    }


    @OnClick({R.id.tv_withdraw, R.id.tv_select, R.id.tv_confirm, R.id.tv_all, R.id.tv_income, R.id.tv_expenditure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_withdraw:
                startActivity(new Intent(this, MineWithdrawActivity.class));
                break;
            case R.id.tv_select:
                llType.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_confirm:
                smartRefresh.autoRefresh();
                break;
            case R.id.tv_all:
                llType.setVisibility(View.GONE);
                tvSelect.setText("全部");
                mType = "0";
                break;
            case R.id.tv_income:
                llType.setVisibility(View.GONE);
                tvSelect.setText("收入");
                mType = "1";
                break;
            case R.id.tv_expenditure:
                llType.setVisibility(View.GONE);
                tvSelect.setText("支出");
                mType = "2";
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserInfoEvent event) {
        mPresenter.getUserInfo();
    }

    @Override
    public void getUserInfoSu(UserBean userBean) {
        tvMoney.setText("￥" + userBean.getBaseData().getMoney());
        BaseApplication.setUserBean(userBean);

    }

    @Override
    public void revenueListSu(RevenueListBean bean) {

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


}
