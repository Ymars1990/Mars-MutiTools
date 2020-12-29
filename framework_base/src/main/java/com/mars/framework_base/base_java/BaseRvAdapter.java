package com.mars.framework_base.base_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * 基类Rv适配器
 */
public abstract class BaseRvAdapter<T, VH extends BaseRvAdapter.BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected ArrayList<T> data;
    protected BaseRvItemOnClicker<T> baseRvItemOnClicker;
    protected Context mCtx;
    protected int itemLayout;

    public BaseRvAdapter(Context mCtx, ArrayList<T> data, BaseRvItemOnClicker<T> baseRvItemOnClicker, int itemLayout) {
        this.data = data;
        this.baseRvItemOnClicker = baseRvItemOnClicker;
        this.mCtx = mCtx;
        this.itemLayout = itemLayout;
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mCtx).inflate(itemLayout, parent, false);
        return initViewHolderView(mCtx, itemView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (data != null && data.size() == 0) {
            return;
        }
        if (holder == null) {
            return;
        }
        bindViewHolder(holder, data.get(position), position);
    }

    /**
     * * 绑定数据
     *
     * @param holder
     * @param itemData
     * @param position
     */
    public abstract void bindViewHolder(VH holder, T itemData, int position);

    /**
     * 初始化控件
     * 调整布局
     *
     * @param mCtx
     */
    public abstract VH initViewHolderView(Context mCtx, View itemView);

    /**
     * 设置Item子View点击监听
     */
    public void setItemViewOnClicker(View v, T itemData, int position) {
        if (v != null && baseRvItemOnClicker != null) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baseRvItemOnClicker.onRvItemClick(v, itemData, position);
                }
            });
        }
    }


    static abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

