package com.groundbuy.mine_model.mvp.contract;

import com.groundbuy.http.HttpResult;
import com.groundbuy.mine_model.bean.MyCommentBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/10
 */
public interface MineCommentListContract {
    interface IView extends MineBaseView {
        void  getCommentListSu(MyCommentBean bean);
    }

    interface  IModel{
        Observable<HttpResult<MyCommentBean>> getCommentList(String page,String pageSize);
    }
}
