package com.groundbuy.mine_model.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.groundbuy.R;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.io.IOException;

import io.reactivex.functions.Consumer;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class UCropUtil {
    public static final int TAKE_PHOTO = 1;//拍照
    public static final int CHOOSE_PHOTO = 2;//选择相册
    public static final int SUCCESS_CODE = 11;//选择成功返回码
    public static Uri imageUri;//相机拍照图片保存地址


    /**
     * 打开相机
     * 兼容7.0
     *
     * @param activity
     */
    @SuppressLint("CheckResult")
    public static void handlepicture(final Activity activity) {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) activity);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA).subscribe(granted -> {
            if (granted) {

                File outputImage = new File(activity.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT < 24) {
                    imageUri = Uri.fromFile(outputImage);
                } else {
                    imageUri = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", outputImage);
                }
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                activity.startActivityForResult(intent, TAKE_PHOTO);
            } else {
                ToastUtils.showShort("拒绝权限将无法使用该功能");
            }
        });
    }


    /**
     * @param activity     从相册选取,只有相册
     * @param ChooseNumber 最多可选择数量
     */
    @SuppressLint("CheckResult")
    public static void openAlbum(final Activity activity, final int ChooseNumber) {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) activity);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    Matisse.from(activity)
                            .choose(MimeType.of(MimeType.PNG, MimeType.JPEG))
                            .theme(R.style.Matisse_Dracula)
                            .countable(false)
                            .maxSelectable(ChooseNumber)
                            .spanCount(3)
                            .originalEnable(true)
                            .maxOriginalSize(10)
                            .imageEngine(new GlideEngine())
                            .forResult(SUCCESS_CODE);
                } else {
                    ToastUtils.showShort("拒绝权限将无法使用该功能");
                }
            }
        });


    }

    /**
     * @param activity     从相册选取或拍照
     * @param ChooseNumber 最多可选择数量
     */
    @SuppressLint("CheckResult")
    public static void cameraAndAlbum(final Activity activity, final int ChooseNumber) {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) activity);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    Matisse.from(activity)
                            .choose(MimeType.of(MimeType.PNG, MimeType.JPEG))
                            .capture(true)
                            .captureStrategy(new CaptureStrategy(true, activity.getApplicationContext().getPackageName() + ".FileProvider"))
                            .theme(R.style.Matisse_Dracula)
                            .countable(false)
                            .maxSelectable(ChooseNumber)
                            .spanCount(3)
                            .originalEnable(true)
                            .maxOriginalSize(10)
                            .imageEngine(new GlideEngine())
                            .forResult(SUCCESS_CODE);
                } else {
                    ToastUtils.showShort("拒绝权限将无法使用该功能");
                }
            }
        });


    }

    /**
     * 启动裁剪圆形
     *
     * @param activity  上下文
     * @param sourceUir 需要裁剪图片的Uri
     *                  //     * @param aspectRatioX 裁剪图片宽高比
     *                  //     * @param aspectRatioY 裁剪图片宽高比
     * @return
     */
    public static void startUCropCircle(Activity activity, Uri sourceUir) {

        UCrop.Options options = new UCrop.Options();
        Uri destinationUri = Uri.fromFile(new File(activity.getExternalCacheDir(), System.currentTimeMillis() + "uCrop.jpg"));
        UCrop uCrop = UCrop.of(sourceUir, destinationUri);//第一个参数是裁剪前的uri,第二个参数是裁剪后的uri
        uCrop.withAspectRatio(1, 1);//设置裁剪框的宽高比例
        options.setAllowedGestures(UCropActivity.ALL, UCropActivity.NONE, UCropActivity.ALL);
        options.setToolbarTitle("移动和缩放");//设置标题栏文字
        options.setMaxScaleMultiplier(3);//设置最大缩放比例
        options.setHideBottomControls(true);//隐藏下边控制栏
        options.setCropFrameStrokeWidth(10);//设置裁剪框的宽度
        options.setCircleDimmedLayer(true);//设置是否为圆形裁剪框
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setShowCropGrid(false);
        options.setShowCropFrame(false); //设置是否显示裁剪边框(true为方形边框)
        options.setToolbarWidgetColor(Color.parseColor("#ffffff"));//标题字的颜色以及按钮颜色
        options.setDimmedLayerColor(Color.parseColor("#7B000000"));//设置裁剪外颜色
        options.setToolbarColor(Color.parseColor("#000000")); // 设置标题栏颜色
        options.setStatusBarColor(Color.parseColor("#000000"));//设置状态栏颜色
        uCrop.withOptions(options);
        uCrop.start(activity);

    }

    /**
     * 启动裁剪
     *
     * @param
     * @param sourceUir 需要裁剪图片的Uri
     * @return
     */
    public static void startUCrop(Activity activity, Uri sourceUir) {
        UCrop.Options options = new UCrop.Options();
        Uri destinationUri = Uri.fromFile(new File(activity.getExternalCacheDir(), System.currentTimeMillis() + "UcropImage.jpg"));
        UCrop uCrop = UCrop.of(sourceUir, destinationUri);//第一个参数是裁剪前的uri,第二个参数是裁剪后的uri
        uCrop.withAspectRatio(1, 1);//设置裁剪框的宽高比例
        options.setAllowedGestures(UCropActivity.ALL, UCropActivity.NONE, UCropActivity.ALL);
        options.setToolbarTitle("移动和缩放");//设置标题栏文字
        options.setMaxScaleMultiplier(3);//设置最大缩放比例
        options.setHideBottomControls(true);//隐藏下边控制栏
        options.setCropFrameStrokeWidth(10);//设置裁剪框的宽度
        options.setCircleDimmedLayer(false);//设置是否为圆形裁剪框
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setShowCropGrid(false);
        options.setShowCropFrame(true); //设置是否显示裁剪边框(true为方形边框)
        options.setToolbarWidgetColor(Color.parseColor("#ffffff"));//标题字的颜色以及按钮颜色
        options.setDimmedLayerColor(Color.parseColor("#AA000000"));//设置裁剪外颜色
        options.setToolbarColor(Color.parseColor("#000000")); // 设置标题栏颜色
        options.setStatusBarColor(Color.parseColor("#000000"));//设置状态栏颜色
        uCrop.withOptions(options);
        uCrop.start(activity);
    }

    /**
     * 启动裁剪
     *
     * @param
     * @param fragment
     * @param sourceUir    需要裁剪图片的Uri
     * @param aspectRatioX 裁剪图片宽高比
     * @param aspectRatioY 裁剪图片宽高比
     * @param request      fragment请求码
     * @return
     */
    public static void startFragmentUCrop(Activity activity, Fragment fragment, Uri sourceUir, float aspectRatioX, float aspectRatioY, int request) {
        UCrop.Options options = new UCrop.Options();
        File outputImage = new File(activity.getExternalCacheDir(), System.currentTimeMillis() + "BackGround.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri destinationUri = Uri.fromFile(outputImage);
        UCrop uCrop = UCrop.of(sourceUir, destinationUri);//第一个参数是裁剪前的uri,第二个参数是裁剪后的uri
        uCrop.withAspectRatio(aspectRatioX, aspectRatioY);//设置裁剪框的宽高比例
        options.setAllowedGestures(UCropActivity.ALL, UCropActivity.NONE, UCropActivity.ALL);
        options.setToolbarTitle("移动和缩放");//设置标题栏文字
        options.setMaxScaleMultiplier(3);//设置最大缩放比例
        options.setHideBottomControls(true);//隐藏下边控制栏
        options.setCropFrameStrokeWidth(10);//设置裁剪框的宽度
        options.setCircleDimmedLayer(false);//设置是否为圆形裁剪框
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
        options.setShowCropGrid(false);
        options.setShowCropFrame(true); //设置是否显示裁剪边框(true为方形边框)
        options.setToolbarWidgetColor(Color.parseColor("#ffffff"));//标题字的颜色以及按钮颜色
        options.setDimmedLayerColor(Color.parseColor("#7B000000"));//设置裁剪外颜色
        options.setToolbarColor(Color.parseColor("#000000")); // 设置标题栏颜色
        options.setStatusBarColor(Color.parseColor("#000000"));//设置状态栏颜色
        uCrop.withOptions(options);
        uCrop.start(activity, fragment, request);

    }


}
