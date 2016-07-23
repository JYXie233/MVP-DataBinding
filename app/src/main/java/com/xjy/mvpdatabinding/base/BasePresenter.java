package com.xjy.mvpdatabinding.base;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 14:48
 * FIXME
 */
public abstract class BasePresenter<V extends IBaseView>{
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }
}