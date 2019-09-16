package com.groundbuy.mine_model.utils;

import com.bumptech.glide.request.RequestOptions;
import com.groundbuy.R;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class GlideUtils {
    public static RequestOptions getRequestOptions() {
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.mine_image_user).error(R.mipmap.mine_image_user);
        return options;
    }
}
