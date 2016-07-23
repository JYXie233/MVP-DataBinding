package com.xjy.mvpdatabinding.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import rx.Observable;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 14:47
 * FIXME
 */
public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    protected P mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter = null;
        }
    }

    @Override
    public void showProgress(String msg) {
        Observable.just(msg)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        getProgressDialog().setMessage(s);
                        if (!getProgressDialog().isShowing())
                            getProgressDialog().show();
                    }
                });
    }

    @Override
    public void dismissProgress() {
        AndroidSchedulers.mainThread().createWorker().schedule(new Action0() {
            @Override
            public void call() {
                if (getProgressDialog().isShowing())
                    getProgressDialog().dismiss();
            }
        });
    }

    @Override
    public void showError(String msg) {
        Observable.just(msg)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(BaseActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void showInfo(String msg) {
        Observable.just(msg)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(BaseActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public ProgressDialog getProgressDialog() {
        if (null == mProgressDialog) {
            mProgressDialog = new ProgressDialog(this);
        }
        return mProgressDialog;
    }
}