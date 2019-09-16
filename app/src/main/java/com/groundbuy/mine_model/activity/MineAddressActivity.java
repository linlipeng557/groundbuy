package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.AddressAdapter;
import com.groundbuy.mine_model.mvp.contract.MineAddressContract;
import com.groundbuy.mine_model.mvp.model.MineAddressModel;
import com.groundbuy.mine_model.mvp.presenter.MineAddressPresenter;
import com.groundbuy.mine_model.mvp.presenter.MineBasePrestener;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MineAddressActivity extends MineBaseActivity<MineAddressPresenter> implements MineAddressContract.IView {


    @BindView(R.id.rv_address)
    RecyclerView rvAddress;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.iv_no_address)
    ImageView ivNoAddress;
    @BindView(R.id.tv_no_address)
    TextView tvNoAddress;
    private AddressAdapter mAdapter;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_address;
    }

    @Override
    protected MineAddressPresenter initPresenter() {
        return new MineAddressPresenter(this, new MineAddressModel(this));
    }
    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        ivNoAddress.setVisibility(View.GONE);
        tvNoAddress.setVisibility(View.GONE);
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            mList.add("AAAAA");
        }
        mAdapter = new AddressAdapter(mList);
        rvAddress.setLayoutManager(new LinearLayoutManager(this));
        rvAddress.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_default:
                        break;
                    case R.id.tv_edit:
                        startActivity(new Intent(MineAddressActivity.this, MineEditAddressActivity.class).putExtra("Type", 1));
                        break;
                    case R.id.tv_del:
                        new GeneralDialog.Builder(MineAddressActivity.this).setContent("您确定要删除该地址吗？")
                                .setLeftAndRight(new GeneralDialog.Builder.LeftAndRightAble() {
                                    @Override
                                    public void onLeftClick(GeneralDialog dialog) {
                                        dialog.dismiss();
                                    }

                                    @Override
                                    public void onRightClick(GeneralDialog dialog) {
                                        dialog.dismiss();
                                        ToastUtils.showShort("删除position==" + position);
                                    }
                                }).create();
                        break;
                    default:
                }
            }
        });

    }


    @OnClick(R.id.tv_add)
    public void onViewClicked() {
        startActivity(new Intent(MineAddressActivity.this, MineEditAddressActivity.class).putExtra("Type", 0));
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }
}
