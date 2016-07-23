package com.xjy.mvpdatabinding;

import android.view.View;

import com.xjy.mvpdatabinding.base.IBasePresenter;
import com.xjy.mvpdatabinding.base.IBaseView;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 15:55
 * FIXME
 */
public interface MainContract {
    interface IView extends IBaseView{
        void onGetPostInfo(PostInfo postInfo);
        void onPostNameClick(View view);
        void onSearchClick(View view);
    }

    interface IPresenter extends IBasePresenter{
        void getPostInfo(MainViewModel mainViewModel);
        String[] getPostCompanys();
        String getPostType(String postCompany);
    }
}  