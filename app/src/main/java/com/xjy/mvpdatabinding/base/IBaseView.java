package com.xjy.mvpdatabinding.base;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 14:49
 * FIXME
 */
public interface IBaseView {
    void showProgress(String msg);
    void dismissProgress();
    void showInfo(String msg);
    void showError(String msg);
}  