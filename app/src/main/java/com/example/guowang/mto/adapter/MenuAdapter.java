package com.example.guowang.mto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guowang.mto.R;
import com.example.guowang.mto.bean.MenuInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: adapter
 * @Description:适配menu
 * @author: 天源迪科
 * @date: 2017-3-15 13:12
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<MenuInfoBean> getList() {
        return mlist;
    }

    public void setList(ArrayList<MenuInfoBean> list) {
        this.mlist = list;
    }

    Context mContext;
    ArrayList<MenuInfoBean> mlist;

    public MenuAdapter(Context mContext, ArrayList<MenuInfoBean> list) {
        this.mContext = mContext;
        this.mlist = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_ITEM) {
            holder = new myVieHolder(View.inflate(mContext, R.layout.item_menu, null));

        } else if (viewType == TYPE_HEADER) {
            holder = new myHeaderHolder(View.inflate(mContext, R.layout.item_menu_head, null));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isPositionHeader(position)) {
            myHeaderHolder headerHolder = (myHeaderHolder) holder;
            headerHolder.mimageView.setImageResource(R.mipmap.topinfo_ban_bg);
        } else {
            myVieHolder ItemVieHolder = (myVieHolder) holder;
            ItemVieHolder.mTextView.setText(mlist.get(position-1).getName());
            ItemVieHolder.mImageView.setImageResource(mlist.get(position-1).getImageId());
        }

    }

    @Override
    public int getItemCount() {
        return mlist.size()+1;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }


    class myVieHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public myVieHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_menu_name);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_item_menu_icon);
        }
    }

    class myHeaderHolder extends RecyclerView.ViewHolder {
        ImageView mimageView;

        public myHeaderHolder(View itemView) {
            super(itemView);
            mimageView = (ImageView) itemView.findViewById(R.id.iv_item_menu_header);
        }
    }

}
