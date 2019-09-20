package com.groundbuy.mine_model.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.groundbuy.BaseApplication;
import com.groundbuy.R;
import com.groundbuy.http.HttpObserver;
import com.groundbuy.http.RetrofitHandler;
import com.groundbuy.http.RxTransformerHelper;
import com.groundbuy.mine_model.bean.AvatarBean;
import com.groundbuy.mine_model.bean.BaseEntiy;
import com.groundbuy.mine_model.bean.UserBean;
import com.groundbuy.mine_model.event.ChangeAvtartEvent;
import com.groundbuy.mine_model.event.NickNameEventBus;
import com.groundbuy.mine_model.mvp.contract.MinePersonalContract;
import com.groundbuy.mine_model.mvp.model.MinePersonalModel;
import com.groundbuy.mine_model.mvp.presenter.MinePersonalPresenter;
import com.groundbuy.mine_model.utils.GlideUtils;
import com.groundbuy.mine_model.utils.UCropUtil;
import com.groundbuy.mine_model.widgets.dialog.BottomSelectDilaog;
import com.groundbuy.mine_model.widgets.dialog.LoadingHorizontal;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yalantis.ucrop.UCrop;
import com.zhihu.matisse.Matisse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class MinePersonalActivity extends MineBaseActivity<MinePersonalPresenter> implements MinePersonalContract.IView {


    @BindView(R.id.iv_head)
    RoundedImageView ivHead;
    @BindView(R.id.ll_head)
    LinearLayout llHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.ll_nick)
    LinearLayout llNick;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.ll_sex)
    LinearLayout llSex;
    private BottomSelectDilaog mHeadDialog, mSexDialog;
    private int mSex;

    @Override
    public Integer contentViewId() {
        return R.layout.activity_mine_personal;
    }


    @Override
    protected MinePersonalPresenter initPresenter() {
        return new MinePersonalPresenter(this, new MinePersonalModel(this));
    }

    @Override
    public void doMore(@Nullable Bundle savedInstanceState) {
        super.doMore(savedInstanceState);

        EventBus.getDefault().register(this);
        tvNick.setText(BaseApplication.getUserBean().getBaseData().getName());
        int sex = BaseApplication.getUserBean().getBaseData().getSex();
        if (sex == 0) {
            tvSex.setText("男");
        } else {
            tvSex.setText("女");
        }
        String img = BaseApplication.getUserBean().getBaseData().getPortrait();
        Glide.with(this).load(BaseApplication.getUserBean().getBaseData().getPortrait()).apply(GlideUtils.getRequestOptions()).into(ivHead);


    }

    @OnClick({R.id.ll_head, R.id.ll_nick, R.id.ll_sex})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_head:
                if (mHeadDialog == null) {
                    mHeadDialog = new BottomSelectDilaog(this, 0);
                    mHeadDialog.setOnSelectListener(new BottomSelectDilaog.OnSelectListener() {
                        @Override
                        public void onTop() {
                            UCropUtil.handlepicture(this_());
                        }

                        @Override
                        public void onBottom() {
                            UCropUtil.openAlbum(this_(), 1);
                        }
                    });
                    mHeadDialog.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mHeadDialog.changeBg(1f);
                        }
                    });
                    mHeadDialog.showAtLocation(llHead, Gravity.BOTTOM, 0, 0);
                } else {
                    mHeadDialog.showAtLocation(llHead, Gravity.BOTTOM, 0, 0);
                }

                break;
            case R.id.ll_nick:
                startActivity(new Intent(this, MineNickNameActivity.class));
                break;
            case R.id.ll_sex:
                if (mSexDialog == null) {
                    mSexDialog = new BottomSelectDilaog(this, 1);
                    mSexDialog.setOnSelectListener(new BottomSelectDilaog.OnSelectListener() {
                        @Override
                        public void onTop() {
                            mSex = 0;
                            mPresenter.changeSex("0");
                        }

                        @Override
                        public void onBottom() {
                            mSex = 1;
                            mPresenter.changeSex("1");
                        }
                    });
                    mSexDialog.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            mSexDialog.changeBg(1f);
                        }
                    });
                    mSexDialog.showAtLocation(llHead, Gravity.BOTTOM, 0, 0);
                } else {
                    mSexDialog.showAtLocation(llHead, Gravity.BOTTOM, 0, 0);
                }

                break;
        }
    }


    @Override
    protected void onDestroy() {
        if (mHeadDialog != null) {
            mHeadDialog.dismiss();
            mHeadDialog = null;
        }
        if (mSexDialog != null) {
            mSexDialog.dismiss();
            mSexDialog = null;
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case UCropUtil.TAKE_PHOTO:
                    UCropUtil.startUCropCircle(this, UCropUtil.imageUri);
                    break;
                case UCropUtil.SUCCESS_CODE:
                    try {
                        if (data != null) {
                            UCropUtil.startUCropCircle(this, Matisse.obtainResult(data).get(0));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    break;
                case UCrop.REQUEST_CROP://剪切返回
                    Uri imageUri1 = UCrop.getOutput(data);
                    luBanCompress(imageUri1);
                    break;
                case UCrop.RESULT_ERROR:
                    ToastUtils.showShort("无法保存裁剪图片");
                    break;
                default:
                    break;
            }
        }
    }


    public void luBanCompress(Uri imageUri1) {
        Luban.with(this)
                .load(imageUri1)
                .ignoreBy(100)
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(File file) {
                        mPresenter.updateAvatar(file);


                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }).launch();

    }

    @Override
    public void changeSexSuccess(BaseEntiy base) {
        ToastUtils.showShort("修改成功");
        UserBean userBean = BaseApplication.getUserBean();
        userBean.getBaseData().setSex(mSex);
        BaseApplication.setUserBean(userBean);
        if (mSex == 0) {
            tvSex.setText("男");
        } else {
            tvSex.setText("女");
        }


    }

    @Override
    public void updateAvatarSuccess(AvatarBean bean) {
        Log.d("FFSFSD",""+bean.getBaseData().get(0));
        UserBean userBean = BaseApplication.getUserBean();
        userBean.getBaseData().setPortrait(RetrofitHandler.BASE_URL + bean.getBaseData().get(0));
        BaseApplication.setUserBean(userBean);
        Glide.with(this_()).load(RetrofitHandler.BASE_URL + bean.getBaseData().get(0)).apply(GlideUtils.getRequestOptions()).into(ivHead);
        EventBus.getDefault().post(new ChangeAvtartEvent());
        mPresenter.changeAvatar(bean.getBaseData().get(0));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvents(NickNameEventBus eventBus) {
        tvNick.setText(eventBus.getName());
    }


}