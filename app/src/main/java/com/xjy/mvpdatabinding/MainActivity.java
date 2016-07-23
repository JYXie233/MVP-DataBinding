package com.xjy.mvpdatabinding;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.xjy.mvpdatabinding.base.BaseActivity;
import com.xjy.mvpdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainContract.IPresenter> implements MainContract.IView {

    private ActivityMainBinding mBinding;
    private MainViewModel mainViewModel = new MainViewModel();
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        mBinding.setModel(mainViewModel);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter();
        mBinding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onGetPostInfo(PostInfo postInfo) {
        mAdapter.setDataBeans(postInfo.getData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPostNameClick(View view) {

        AlertDialog alertDialog = new AlertDialog.Builder(this).setItems(mPresenter.getPostCompanys(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mainViewModel.postName.set(mPresenter.getPostCompanys()[which]);
                mainViewModel.postType.set(mPresenter.getPostType(mPresenter.getPostCompanys()[which]));
            }
        }).create();
        alertDialog.show();
    }

    @Override
    public void onSearchClick(View view) {
        mPresenter.getPostInfo(mainViewModel);
    }
}
