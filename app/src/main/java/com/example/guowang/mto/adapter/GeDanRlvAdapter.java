package com.example.guowang.mto.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guowang.mto.activity.PlaylistActicity;
import com.example.guowang.mto.R;
import com.example.guowang.mto.bean.GedanInfoBean;

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
            final GedanInfoBean infoBean = mlist.get(position);
            if (infoBean != null) {
                ((ItemViewHolder) holder).mTvDic.setText(infoBean.getTitle());
                int count = Integer.parseInt(infoBean.getListenum());
                if (count > 10000) {
                    count = count / 10000;
                    ((ItemViewHolder) holder).mTvCount.setText(" " + count + "万");
                } else {
                    ((ItemViewHolder) holder).mTvCount.setText(" " + infoBean.getListenum());
                }
                //加载图片
                Glide.with(mContext).load(infoBean.getPic_300()).into(((ItemViewHolder) holder).mIvPic);
            /*    if (infoBean.getPic_300().indexOf("http://ugcpic.") == -1) {
                    L.e("infoBean.getPic_300()=" + infoBean.getPic_300());
                    ImageLoader.downloadImg(mContext, ((ItemViewHolder) holder).mIvPic, infoBean.getPic_300());
                } else {
                    ((ItemViewHolder) holder).mIvPic.setImageResource(R.drawable.actionbar_music);
                }*/
            }


            ((ItemViewHolder) holder).mIvPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PlaylistActicity.class);
                    intent.putExtra("playlistid", infoBean.getListid());
                    intent.putExtra("islocal", false);
                    intent.putExtra("albumart", infoBean.getPic_300());
                    intent.putExtra("playlistname", infoBean.getTitle());
                    intent.putExtra("playlistDetail", infoBean.getTag());
                    intent.putExtra("playlistcount", infoBean.getListenum());
                    mContext.startActivity(intent);
                }
            });


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
        this.mlist.clear();
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
