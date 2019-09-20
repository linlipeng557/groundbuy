package com.groundbuy.mine_model.mvp.model;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.MyCommentBean;
import com.groundbuy.mine_model.mvp.contract.MineCommentListContract;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public class MineCommentListModel extends MineBaseModel<MineCommentListContract.IView> implements MineCommentListContract.IModel{
    public MineCommentListModel(MineCommentListContract.IView view) {
        super(view);
    }

    @Override
    public Observable<HttpResult<MyCommentBean>> getCommentList(String page, String pageSize) {
        HashMap<String,String> map = new HashMap<>();
        map.put("page",page);
        map.put("pageSize",pageSize);
        return apiService.getCommentList(getRequestBody(map));
    }
}
