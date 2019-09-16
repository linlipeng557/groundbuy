package com.groundbuy.mine_model.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.groundbuy.R;
import com.groundbuy.mine_model.bean.ExchangeDetailsBean;
import com.groundbuy.mine_model.mvp.contract.MineConvertDetailsContract;
import com.groundbuy.mine_model.mvp.model.MineConvertDetailsModel;
import com.groundbuy.mine_model.mvp.presenter.MineConvertDetailsPresenter;
import com.groundbuy.mine_model.utils.MineGlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineConvertDetailsActivity extends MineBaseActivity<MineConvertDetailsPresenter> implements MineConvertDetailsContract.IView {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.nest_view)
    NestedScrollView nestView;
    @BindView(R.id.banner_convert)
    Banner bannerConvert;
    @BindView(R.id.tv_ub)
    TextView tvUb;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_address_name)
    TextView tvAddressName;
    @BindView(R.id.tv_address)
    TextView tvAddress;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_convert_details;
    }


    @Override
    protected MineConvertDetailsPresenter initPresenter() {
        return new MineConvertDetailsPresenter(this, new MineConvertDetailsModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        String exchangeId = getIntent().getStringExtra("exchangeId");
        nestView.setVisibility(View.GONE);
        mPresenter.exchangeInfo(exchangeId);

    }


    @Override
    public void showDialog() {
        showBaseDialog();
    }

    @Override
    public void dismissDialog() {
        dismissBaseDialog();
    }

    @Override
    public void exchangeInfoSu(ExchangeDetailsBean bean) {
        if (bean == null) {
            return;
        }
        nestView.setVisibility(View.VISIBLE);
        tvAddress.setText(bean.getAddress().getProvince() + "-" + bean.getAddress().getCity() + "-" + bean.getAddress().getArea() + "-" + bean.getAddress().getAddress());
        tvAddressName.setText(bean.getAddress().getName());
        tvPhone.setText(bean.getAddress().getMobile());

        tvUb.setText(bean.getUbGoods().getNeedUB());
        tvName.setText(bean.getUbGoods().getDesc());
        tvType.setText(bean.getUbGoods().getAttributeInfo());

        bannerConvert.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        bannerConvert.setImageLoader(new MineGlideImageLoader());
        bannerConvert.setImages(bean.getUbGoods().getImgUrls());
        bannerConvert.setDelayTime(3000);
        bannerConvert.setIndicatorGravity(BannerConfig.NOT_INDICATOR);
        bannerConvert.start();
    }


}
