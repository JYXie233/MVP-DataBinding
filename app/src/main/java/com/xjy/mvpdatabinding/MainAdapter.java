package com.xjy.mvpdatabinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xjy.mvpdatabinding.BR;

import java.util.List;

/**
 * User: Tom
 * Date: 2016-07-23
 * Time: 16:27
 * FIXME
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private List<PostInfo.DataBean> mDataBeans;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.model, mDataBeans.get(position));
        holder.getBinding().executePendingBindings();
    }



    @Override
    public int getItemCount() {
        return mDataBeans == null ? 0: mDataBeans.size();
    }

    public List<PostInfo.DataBean> getDataBeans() {
        return mDataBeans;
    }

    public void setDataBeans(List<PostInfo.DataBean> mDataBeans) {
        this.mDataBeans = mDataBeans;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mBinding;
        public ViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }
    }
}