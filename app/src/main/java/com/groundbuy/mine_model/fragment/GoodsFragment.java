package com.groundbuy.mine_model.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.groundbuy.R;
import com.groundbuy.mine_model.adapter.MineGoodsAdapter;
import com.groundbuy.mine_model.bean.CollectGoodsBean;
import com.groundbuy.mine_model.bean.CollectShopBean;
import com.groundbuy.mine_model.mvp.contract.ShopOrGoodsContract;
import com.groundbuy.mine_model.mvp.model.ShopOrGoodsModel;
import com.groundbuy.mine_model.mvp.presenter.ShopOrGoodsPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/16
 */
public class GoodsFragment extends MineBaseFragment<ShopOrGoodsPresenter> implements ShopOrGoodsContract.IView {
    @BindView(R.id.rv_shop_goods)
    RecyclerView rvGoods;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.tv_del)
    TextView tvDel;
    @BindView(R.id.ll_del)
    LinearLayout llDel;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.tv_check_no)
    TextView tvCheckNo;
    @BindView(R.id.tv_check_yes)
    TextView tvCheckYes;
    private MineGoodsAdapter mAdapter;
    private List<CollectGoodsBean.BaseDataBean.ListBean> mListBean = new ArrayList<>();
    private int mPage = 1;
    private boolean mIsAdd;

    @Override
    public Integer contentViewLayout() {
        return R.layout.fragment_mine_shop;
    }

    @Override
    protected ShopOrGoodsPresenter initPresenter() {
        return new ShopOrGoodsPresenter(this, new ShopOrGoodsModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);

        llDel.setVisibility(View.GONE);

        rvGoods.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new MineGoodsAdapter(mListBean);
        rvGoods.setAdapter(mAdapter);
        smartRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                mPresenter.collGoods("" + mPage, "" + 20);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPage = 1;
                mPresenter.collGoods("" + mPage, "" + 20);
            }
        });
        smartRefresh.autoRefresh();

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

    }

    @OnClick({R.id.tv_add, R.id.tv_del, R.id.tv_check_no, R.id.tv_check_yes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
            case R.id.tv_check_no:
            case R.id.tv_check_yes:
                if (mIsAdd) {
                    mAdapter.addMap();
                    mAdapter.notifyDataSetChanged();
                    mIsAdd = false;
                    tvCheckNo.setVisibility(View.GONE);
                    tvCheckYes.setVisibility(View.VISIBLE);
                    tvAdd.setText("取消全选");
                } else {
                    mAdapter.clearMap();
                    mAdapter.notifyDataSetChanged();
                    mIsAdd = true;
                    tvCheckNo.setVisibility(View.VISIBLE);
                    tvCheckYes.setVisibility(View.GONE);
                    tvAdd.setText("全选");
                }
                break;
            case R.id.tv_del:
                for (int i = 0; i < mAdapter.getMap().size(); i++) {
                    if (mAdapter.getMap().get(i)) {
                        break;
                    } else if (i == mAdapter.getMap().size() - 1) {
                        ToastUtils.showShort("请选择要删除的商品");
                    }
                }
                break;
        }
    }


    public void setEdit(boolean b) {
        if (b) {
            llDel.setVisibility(View.VISIBLE);
        } else {
            llDel.setVisibility(View.GONE);
        }
        mAdapter.clearMap();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDialog() {
        showDialog();
    }

    @Override
    public void dismissDialog() {
        dismissDialog();
    }

    @Override
    public void collectShopSu(CollectShopBean bean) {
        if (smartRefresh.isLoading()) {
            smartRefresh.finishLoadMore();
            smartRefresh.finishRefresh();
        }
    }

    @Override
    public void collGoodsSu(CollectGoodsBean bean) {
        smartRefresh.finishLoadMore();
        smartRefresh.finishRefresh();
        if (bean == null || bean.getBaseData() == null || bean.getBaseData().getList() == null || bean.getBaseData().getList().size() == 0) {
            // tvHint.setText("暂无更多数据");
            smartRefresh.setEnableLoadMore(false);
            return;
        }

        if (bean.getBaseData().isFirstPage()) {
            mListBean.clear();
        }
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        mListBean.addAll(bean.getBaseData().getList());
        if (bean.getBaseData().isLastPage()) {
            smartRefresh.setEnableLoadMore(false);
        } else {
            smartRefresh.setEnableLoadMore(true);
        }
        mAdapter.notifyDataSetChanged();
    }
}
