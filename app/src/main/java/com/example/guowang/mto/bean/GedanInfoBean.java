package com.example.guowang.mto.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class GedanInfoBean implements Serializable {

    /**
     * listid : 365142031
     * listenum : 9507
     * collectnum : 67
     * title : 纯音乐|做一个斑斓的梦
     * pic_300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/e073cbc757b2d447bf2b5cb0be09b07e.jpg
     * tag : 纯音乐,安静,学习
     * desc : 献给世上所有安静、内敛而又温柔的人们。
     * pic_w300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/e073cbc757b2d447bf2b5cb0be09b07e.jpg
     * width : 300
     * height : 300
     * songIds : ["73963244","9701270","73831056","73942462","272144688","74028994","260060296","16650211","245844562","246719817"]
     */

    private String listid;
    private String listenum;
    private String collectnum;
    private String title;
    private String pic_300;
    private String tag;
    private String desc;
    private String pic_w300;
    private String width;
    private String height;
    private List<String> songIds;

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getListenum() {
        return listenum;
    }

    public void setListenum(String listenum) {
        this.listenum = listenum;
    }

    public String getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(String collectnum) {
        this.collectnum = collectnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_300() {
        return pic_300;
    }

    public void setPic_300(String pic_300) {
        this.pic_300 = pic_300;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPic_w300() {
        return pic_w300;
    }

    public void setPic_w300(String pic_w300) {
        this.pic_w300 = pic_w300;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<String> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<String> songIds) {
        this.songIds = songIds;
    }

    @Override
    public String toString() {
        return "GedanInfoBean{" +
                "listid='" + listid + '\'' +
                ", listenum='" + listenum + '\'' +
                ", collectnum='" + collectnum + '\'' +
                ", title='" + title + '\'' +
                ", pic_300='" + pic_300 + '\'' +
                ", tag='" + tag + '\'' +
                ", desc='" + desc + '\'' +
                ", pic_w300='" + pic_w300 + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", songIds=" + songIds +
                '}';
    }
}
