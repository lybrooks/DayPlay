package com.example.guowang.mto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guowang.mto.R;
import com.example.guowang.mto.bean.GeDanDetailBean;
import com.example.guowang.mto.bean.SongBean;
import com.example.guowang.mto.utils.L;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class GeDanListAdapter extends RecyclerView.Adapter {
    public ArrayList<SongBean> getmList() {
        return mList;
    }

    public void setmList(ArrayList<SongBean> mList) {
        this.mList = mList;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public GeDanListAdapter(Context mContext, ArrayList<SongBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    Context mContext;
    ArrayList<SongBean> mList;
    int Type_Title = 0;
    int Type_Item = 1;

    boolean isPlaying = false;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == Type_Title) {
            return new CommonItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gedan_playmenu, parent, false));
        } else {
            return new SongViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gedandetails, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SongViewHolder) {
            SongBean songBean = mList.get(position - 1);

            ((SongViewHolder) holder).tvSongName.setText(songBean.getTitle());
            ((SongViewHolder) holder).tvArtist.setText(songBean.getAuthor());
            if (!isPlaying) {
                ((SongViewHolder) holder).tvSongNum.setText(position + "");
            } else {
                ((SongViewHolder) holder).ivPayer.setVisibility(View.VISIBLE);
                ((SongViewHolder) holder).tvSongNum.setVisibility(View.INVISIBLE);
            }
        } else if (holder instanceof CommonItemViewHolder) {
            ((CommonItemViewHolder) holder).tvAllNumber.setText("(共" + mList.size() + "首)");
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == Type_Title ? Type_Title : Type_Item;

    }

    public void update(ArrayList<SongBean> content) {
        this.mList.clear();
        this.mList.addAll(content);
        notifyDataSetChanged();
    }

    class CommonItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvAllNumber;
        ImageView select;
        RelativeLayout layout;

        CommonItemViewHolder(View view) {
            super(view);
            this.tvAllNumber = (TextView) view.findViewById(R.id.play_all_number);
            this.select = (ImageView) view.findViewById(R.id.select);
            this.layout = (RelativeLayout) view.findViewById(R.id.play_all_layout);
        }

    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongNum, tvSongName, tvArtist;
        ImageView ivPayer, ivMenu;

        public SongViewHolder(View itemView) {
            super(itemView);
            tvSongNum = (TextView) itemView.findViewById(R.id.tv_item_Ge_num);
            tvSongName = (TextView) itemView.findViewById(R.id.tv_title_songname);
            tvArtist = (TextView) itemView.findViewById(R.id.song_artist);
            ivPayer = (ImageView) itemView.findViewById(R.id.play_state);
            ivMenu = (ImageView) itemView.findViewById(R.id.popup_menu);

        }
    }
}