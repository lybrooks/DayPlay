package com.wm.remusic.service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * All rights Reserved, Designed By www.tydic.com
 *
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * Created by guowang on 2017/3/24.
 * @date: ${date} ${time}
 * @Copyright: ${year} www.tydic.com Inc. All rights reserved.
 */
public class MusicTrack implements Parcelable {



    public static final Parcelable.Creator<MusicTrack> CREATOR = new Parcelable.Creator<MusicTrack>() {
        @Override
        public MusicTrack createFromParcel(Parcel source) {
            return new MusicTrack(source);
        }

        @Override
        public MusicTrack[] newArray(int size) {
            return new MusicTrack[size];
        }
    };
    public long mId;
    public int mSourcePosition;
    public String mTitle;
    public String mAlbum;
    public String mArtist;


    public MusicTrack(long id, int sourcePosition) {
        mId = id;
        mSourcePosition = sourcePosition;
//        mTitle = title;
//        mArtist = artist;
//        mAlbum = album;
    }

    public MusicTrack(Parcel in) {
        mId = in.readLong();
        mSourcePosition = in.readInt();
//        mTitle = in.readString();
//        mArtist = in.readString();
//        mAlbum = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeInt(mSourcePosition);
//        dest.writeString(mTitle);
//        dest.writeString(mArtist);
//        dest.writeString(mArtist);

    }
}
