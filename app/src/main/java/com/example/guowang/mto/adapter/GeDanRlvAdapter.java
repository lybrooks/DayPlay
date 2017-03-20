package com.example.guowang.mto.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guowang.mto.R;
import com.example.guowang.mto.bean.GedanInfoBean;
import com.example.guowang.mto.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class GeDanRlvAdapter extends RecyclerView.Adapter {


    public GeDanRlvAdapter(Context context, ArrayList<GedanInfoBean> mlist) {
        this.mContext = context;
        this.mlist = mlist;
    }

    ArrayList<GedanInfoBean> mlist;
    Context mContext;
    public int TYPE_ITEM = 0;
    public int TYPE_FOOTER = 1;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_ITEM) {
            return new ItemViewHolder(layoutInflater.inflate(R.layout.recommend_all_playlist_item, parent, false));
        } else {
            return new FooterViewHolder(layoutInflater.inflate(R.layout.loading, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            GedanInfoBean infoBean = mlist.get(position);
            ((ItemViewHolder) holder).mTvDic.setText(infoBean.getTitle());
            int count = Integer.parseInt(infoBean.getListenum());
            if (count > 10000) {
                count = count / 10000;
                ((ItemViewHolder) holder).mTvCount.setText(" " + count + "万");
            } else {
                ((ItemViewHolder) holder).mTvCount.setText(" " + infoBean.getListenum());
            }
            ImageLoader.downloadImg(mContext, ((ItemViewHolder) holder).mIvPic, infoBean.getPic_300());
        }
        if (holder instanceof FooterViewHolder) {
          ((FooterViewHolder) holder).mIvFooter.setBackgroundResource(R.drawable.list_loading);
            final AnimationDrawable background = (AnimationDrawable) ((FooterViewHolder) holder).mIvFooter.getBackground();
            ((FooterViewHolder) holder).mIvFooter.post(new Runnable() {
                @Override
                public void run() {
                    background.start();
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 : mlist.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == mlist.size() + 1) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    public void upadte(List<GedanInfoBean> list) {
        this.mlist.addAll(list);
        notifyDataSetChanged();
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvFooter;

        public FooterViewHolder(View itemView) {
            super(itemView);
            mIvFooter = (ImageView) itemView.findViewById(R.id.iv_footer_pic);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mTvCount, mTvDic;
        ImageView mIvPic;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTvCount = (TextView) itemView.findViewById(R.id.iv_item_count);
            mTvDic = (TextView) itemView.findViewById(R.id.tv_item_dic);
            mIvPic = (ImageView) itemView.findViewById(R.id.iv_item_pic);
        }
    }


}
