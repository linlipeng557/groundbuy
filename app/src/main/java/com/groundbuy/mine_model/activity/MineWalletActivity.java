package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.WalletAdapter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineWalletActivity extends MineBaseActivity {

    @BindView(R.id.tv_withdraw)
    TextView tvWithdraw;
    @BindView(R.id.tv_select)
    TextView tvSelect;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.rv_details)
    RecyclerView rvDetails;
    private WalletAdapter mAdapter;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_wallet;
    }




    @Override
    public boolean statusBarLightMode() {
        return false;
    }
    @Override
    protected MineBasePrestener initPresenter() {
        return null;
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add("nnn");
        }

        mAdapter = new WalletAdapter(mList);
        rvDetails.setLayoutManager(new LinearLayoutManager(this));
        rvDetails.setAdapter(mAdapter);

    }


    @OnClick({R.id.tv_withdraw, R.id.tv_select, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_withdraw:
                startActivity(new Intent(this,MineWithdrawActivity.class));
                break;
            case R.id.tv_select:
                break;
            case R.id.tv_confirm:
                break;
            default:
        }
    }
}
