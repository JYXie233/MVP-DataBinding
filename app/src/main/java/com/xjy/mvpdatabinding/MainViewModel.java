package com.xjy.mvpdatabinding;

import android.databinding.ObservableField;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 16:01
 * FIXME
 */
public class MainViewModel {
    public ObservableField<String> postName = new ObservableField<>();
    public ObservableField<String> postType = new ObservableField<>();
    public ObservableField<String> postId = new ObservableField<>();
}  