package com.example.guowang.mto.bean;

import java.util.List;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class GeDanBean {


    /**
     * error_code : 22000
     * total : 8284
     * havemore : 1
     * content : [{"listid":"365233147","listenum":"3896","collectnum":"13","title":"「欧美」撩拨前奏控 独特得欲罢不能","pic_300":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/d6437ad4410190007e664f583748d451.jpg","tag":"欧美,电子,兴奋","desc":"前奏：独特的撩拨技巧\n有特色的前奏个性的声线\n轻而易举便撩了前奏控\n\n旋律：超强的毒性\n听一遍 就想循环好多遍\n副歌好听到让人不能再满足\n\n相得益彰的前奏与副歌\n保证被撩得停不下来","pic_w300":"http://musicugc.cdn.qianqian.com/ugcdiy/pic/d6437ad4410190007e664f583748d451.jpg","width":"300","height":"300","songIds":["273147658","62786235","297296200","285131024","268175134","100481153","297291029","303165485","293621474","123073865"]}]
     */

    private int error_code;
    private int total;
    private int havemore;
    private List<GedanInfoBean> content;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHavemore() {
        return havemore;
    }

    public void setHavemore(int havemore) {
        this.havemore = havemore;
    }

    public List<GedanInfoBean> getContent() {
        return content;
    }

    public void setContent(List<GedanInfoBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * listid : 365233147
         * listenum : 3896
         * collectnum : 13
         * title : 「欧美」撩拨前奏控 独特得欲罢不能
         * pic_300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/d6437ad4410190007e664f583748d451.jpg
         * tag : 欧美,电子,兴奋
         * desc : 前奏：独特的撩拨技巧
         有特色的前奏个性的声线
         轻而易举便撩了前奏控

         旋律：超强的毒性
         听一遍 就想循环好多遍
         副歌好听到让人不能再满足

         相得益彰的前奏与副歌
         保证被撩得停不下来
         * pic_w300 : http://musicugc.cdn.qianqian.com/ugcdiy/pic/d6437ad4410190007e664f583748d451.jpg
         * width : 300
         * height : 300
         * songIds : ["273147658","62786235","297296200","285131024","268175134","100481153","297291029","303165485","293621474","123073865"]
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
    }

    @Override
    public String toString() {
        return "GeDanBean{" +
                "error_code=" + error_code +
                ", total=" + total +
                ", havemore=" + havemore +
                ", content=" + content +
                '}';
    }

}
