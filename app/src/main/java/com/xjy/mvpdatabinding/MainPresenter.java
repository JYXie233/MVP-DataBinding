package com.xjy.mvpdatabinding;

import com.xjy.mvpdatabinding.base.BasePresenter;
import com.xjy.mvpdatabinding.request.Request;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 15:56
 * FIXME
 */
public class MainPresenter extends BasePresenter<MainContract.IView> implements MainContract.IPresenter{

    private static Map<String, String> sPostCompany;
    static {
        sPostCompany = new HashMap<>();
        sPostCompany.put("申通", "shentong");
        sPostCompany.put("EMS", "ems");
        sPostCompany.put("顺丰", "shunfeng");
        sPostCompany.put("圆通", "yuantong");
        sPostCompany.put("中通", "zhongtong");
        sPostCompany.put("韵达", "yunda");
        sPostCompany.put("天天", "tiantian");
        sPostCompany.put("汇通", "huitongkuaidi");
        sPostCompany.put("全峰", "quanfengkuaidi");
        sPostCompany.put("德邦", "debangwuliu");
        sPostCompany.put("宅急送", "zhaijisong");
    }

    public MainPresenter(MainContract.IView mView) {
        super(mView);
    }

    @Override
    public void getPostInfo(MainViewModel mainViewModel) {
        mView.showProgress("加载中");
        Request.getApi().getCityList(mainViewModel.postType.get(), mainViewModel.postId.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PostInfo>() {
                    @Override
                    public void onCompleted() {
                        mView.dismissProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dismissProgress();
                        mView.showError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(PostInfo postInfo) {
                        mView.onGetPostInfo(postInfo);
                    }

                });
    }

    @Override
    public String[] getPostCompanys() {
        return sPostCompany.keySet().toArray(new String[]{});
    }

    @Override
    public String getPostType(String postCompany) {
        return sPostCompany.get(postCompany);
    }
}