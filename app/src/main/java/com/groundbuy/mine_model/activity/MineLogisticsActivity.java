package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.LogisticsAdapter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MineLogisticsActivity extends MineBaseActivity {

    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.rv_logistics)
    RecyclerView rvLogistics;
    private LogisticsAdapter mAdapter;
    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_logistics;
    }


    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        List<String> mList = new ArrayList<>();
        mList.add("FSD");
        mList.add("FSD");
        mList.add("FSD");
        mList.add("FSD");
        mList.add("FSD");
        mAdapter = new LogisticsAdapter(mList);
        rvLogistics.setLayoutManager(new LinearLayoutManager(this));
        rvLogistics.setAdapter(mAdapter);
    }


}
