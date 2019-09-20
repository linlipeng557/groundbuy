package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.AddressAdapter;
import com.groundbuy.mine_model.bean.AddressBean;
import com.groundbuy.mine_model.event.AddressEvent;
import com.groundbuy.mine_model.mvp.contract.MineAddressContract;
import com.groundbuy.mine_model.mvp.model.MineAddressModel;
import com.groundbuy.mine_model.mvp.presenter.MineAddressPresenter;
import com.groundbuy.mine_model.widgets.dialog.GeneralDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.ll_no)
    RelativeLayout llNo;
    private AddressAdapter mAdapter;
    private int mPage = 1;
    private List<AddressBean.BaseDataBean.ListBean> mListBean = new ArrayList<>();

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
        EventBus.getDefault().register(this_());
        llNo.setVisibility(View.GONE);
        mAdapter = new AddressAdapter(mListBean);
        rvAddress.setLayoutManager(new LinearLayoutManager(this));
        rvAddress.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_yes://已经是默认了， 使用点击无效
                        break;
                    case R.id.iv_no://点击后选中
                        mPresenter.setDefaultAddress("" + mListBean.get(position).getId(), position);
                        break;
                    case R.id.tv_edit:
                        startActivity(new Intent(MineAddressActivity.this, MineEditAddressActivity.class).putExtra("Type", 1)
                        .putExtra("bean",mListBean.get(position)));
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
                                        mPresenter.deleteAddress(mListBean.get(position).getId() + "", position);
                                    }
                                }).create();
                        break;
                    default:
                }
            }
        });
        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                mPresenter.addressList("" + mPage, "10");
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPage = 1;
                mPresenter.addressList("" + mPage, "10");
            }
        });

        smartRefresh.autoRefresh();


    }


    @OnClick(R.id.tv_add)
    public void onViewClicked() {
        startActivity(new Intent(MineAddressActivity.this, MineEditAddressActivity.class).putExtra("Type", 0));
    }


    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
        if (smartRefresh.isLoading() || smartRefresh.isRefreshing()) {
            smartRefresh.finishLoadMore();
            smartRefresh.finishRefresh();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this_());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AddressEvent event) {
        smartRefresh.autoRefresh();
    }


    @Override
    public void addressListSu(AddressBean bean) {
        smartRefresh.finishLoadMore();
        smartRefresh.finishRefresh();
        if (bean == null || bean.getBaseData() == null || bean.getBaseData().getList() == null || bean.getBaseData().getList().size() == 0) {
            // tvHint.setText("暂无更多数据");
            smartRefresh.setEnableLoadMore(false);
            if (bean.getBaseData().getList().size() == 0 && bean.getBaseData().isFirstPage()) {
                llNo.setVisibility(View.VISIBLE);
            }
            return;
        }
        llNo.setVisibility(View.GONE);

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
    public void deleteAddressSu(int position) {
        ToastUtils.showShort("删除成功");
        mListBean.remove(position);
        mAdapter.notifyItemRemoved(position);
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void setDefaultAddress(int position) {
        for (int i = 0; i < mListBean.size(); i++) {
            if (i == position) {
                mListBean.get(i).setIsChoice(1);
            } else {
                mListBean.get(i).setIsChoice(0);
            }
        }
        mAdapter.notifyDataSetChanged();
    }


}
