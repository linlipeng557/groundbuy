package com.groundbuy.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.groundbuy.R;
import com.groundbuy.http.RetrofitHandler;
import com.groundbuy.mine_model.activity.MineCheckInActivity;
import com.groundbuy.mine_model.activity.MineCollectActivity;
import com.groundbuy.mine_model.activity.MineCommentLisActivity;
import com.groundbuy.mine_model.activity.MineConvertActivity;
import com.groundbuy.mine_model.activity.MineHelpCenterActivity;
import com.groundbuy.mine_model.activity.MineHistoryPugActivity;
import com.groundbuy.mine_model.activity.MineOrderListActivity;
import com.groundbuy.mine_model.activity.MinePersonalActivity;
import com.groundbuy.mine_model.activity.MineRefundActivity;
import com.groundbuy.mine_model.activity.MineSettingActivity;
import com.groundbuy.mine_model.activity.MineWalletActivity;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.event.NickNameEventBus;
import com.groundbuy.mine_model.fragment.MineBaseFragment;
import com.groundbuy.mine_model.mvp.contract.MineContract;
import com.groundbuy.mine_model.mvp.model.MineModel;
import com.groundbuy.mine_model.mvp.presenter.MinePresenter;
import com.groundbuy.mine_model.utils.GlideUtils;
import com.makeramen.roundedimageview.RoundedImageView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends MineBaseFragment<MinePresenter> implements MineContract.IView {
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.iv_user)
    RoundedImageView ivUser;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_wait_pay)
    LinearLayout llWaitPay;
    @BindView(R.id.ll_wait_goods)
    LinearLayout llWaitGoods;
    @BindView(R.id.ll_wait_rece_goods)
    LinearLayout llWaitReceGoods;
    @BindView(R.id.ll_wait_evaluate)
    LinearLayout llWaitEvaluate;
    @BindView(R.id.ll_refund)
    LinearLayout llRefund;
    @BindView(R.id.ll_convert)
    LinearLayout llConvert;
    @BindView(R.id.ll_collect)
    LinearLayout llCollect;
    @BindView(R.id.ll_pug)
    LinearLayout llPug;
    @BindView(R.id.ll_assess)
    LinearLayout llAssess;
    @BindView(R.id.ll_check_in)
    LinearLayout llCheckIn;
    @BindView(R.id.ll_help)
    LinearLayout llHelp;
    @BindView(R.id.tv_wallet)
    TextView tvWallet;
    @BindView(R.id.tv_order)
    TextView tvOrder;

    @Override
    public Integer contentViewLayout() {
        return R.layout.fragment_wd;
    }

    @Override
    protected MinePresenter initPresenter() {
        return new MinePresenter(this, new MineModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);
        EventBus.getDefault().register(this);
        mPresenter.login();

    }

    @OnClick({R.id.iv_setting, R.id.iv_user, R.id.tv_name, R.id.ll_wait_pay, R.id.ll_wait_goods, R.id.ll_wait_rece_goods, R.id.ll_wait_evaluate,
            R.id.ll_refund, R.id.ll_convert, R.id.ll_collect, R.id.ll_pug, R.id.ll_assess, R.id.ll_check_in, R.id.ll_help, R.id.tv_wallet, R.id.tv_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                startActivity(new Intent(getActivity(), MineSettingActivity.class));
                break;
            case R.id.iv_user:
            case R.id.tv_name:
                startActivity(new Intent(getActivity(), MinePersonalActivity.class));
                break;
            case R.id.ll_wait_pay:
                startActivity(new Intent(getActivity(), MineOrderListActivity.class).putExtra("Type", 1));
                break;
            case R.id.ll_wait_goods:
                startActivity(new Intent(getActivity(), MineOrderListActivity.class).putExtra("Type", 2));
                break;
            case R.id.ll_wait_rece_goods:
                startActivity(new Intent(getActivity(), MineOrderListActivity.class).putExtra("Type", 3));
                break;
            case R.id.ll_wait_evaluate:
                startActivity(new Intent(getActivity(), MineOrderListActivity.class).putExtra("Type", 4));
                break;
            case R.id.ll_refund:
                startActivity(new Intent(getActivity(), MineRefundActivity.class));
                break;
            case R.id.tv_order:
                startActivity(new Intent(getActivity(), MineOrderListActivity.class).putExtra("Type", 0));
                break;
            case R.id.ll_convert:
                startActivity(new Intent(getActivity(), MineConvertActivity.class));
                break;
            case R.id.ll_collect:
                startActivity(new Intent(getActivity(), MineCollectActivity.class));
                break;
            case R.id.ll_pug:
                startActivity(new Intent(getActivity(), MineHistoryPugActivity.class));
                break;
            case R.id.ll_assess:
                startActivity(new Intent(getActivity(), MineCommentLisActivity.class));
                break;
            case R.id.ll_check_in:
                startActivity(new Intent(getActivity(), MineCheckInActivity.class));
                break;
            case R.id.ll_help:
                startActivity(new Intent(getActivity(), MineHelpCenterActivity.class));
                break;
            case R.id.tv_wallet:
                startActivity(new Intent(getActivity(), MineWalletActivity.class));
                break;

            default:
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NickNameEventBus event) {
        tvName.setText(event.getName());
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void getUserInfo(UserBean bean) {
        tvName.setText(bean.getBaseData().getName());
        tvWallet.setText("￥" + bean.getBaseData().getMoney());
        Glide.with(getContext()).load(RetrofitHandler.BASE_URL + bean.getBaseData().getPortrait()).apply(GlideUtils.getRequestOptions()).into(ivUser);
    }

    @Override
    public void loginSu(UserBean bean) {
        mPresenter.getUserInfo();
    }
}
