package com.example.guowang.mto.bean;

import java.io.Serializable;
import java.util.List;

/**
 * All rights Reserved, Designed By www.tydic.com
 *
 * @version V1.0
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * Created by guowang on 2017/3/26.
 * @date: ${date} ${time}
 * @Copyright: ${year} www.tydic.com Inc. All rights reserved.
 */

public class LoopImgBean   {

    @Override
    public String toString() {
        return "LoopImgBean{" +
                "error_code=" + error_code +
                ", pic=" + pic +
                '}';
    }

    /**
     * pic : [{"type":2,"mo_type":2,"code":"539733222","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14901972576967f381036a401fefbe4b1dfd2c185b.jpg","randpic_ios5":"","randpic_desc":"","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1490197262e4f73fe8bec5e754a10eaeeccb0acaf3.jpg","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14901972806e3724bf7c5213b8110b6ebe07c24ec7.jpg","randpic_2":"","randpic_iphone6":"","special_type":0,"ipad_desc":"独家首发4天","is_publish":"111111"},{"type":2,"mo_type":2,"code":"539784179","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1490495110d0c6e27b6ee54d032c68e670ff0babba.jpg","randpic_ios5":"","randpic_desc":"","randpic_ipad":"","randpic_qq":"","randpic_2":"","randpic_iphone6":"","special_type":0,"ipad_desc":"","is_publish":"111111"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/h5pc/spec_detail?id=218&columnid=89","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1490349686e5893da764d74b4c6cbb047556c1cd11.jpg","randpic_ios5":"","randpic_desc":"","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1490349691d463f56bb76c4bd916a623ea09a56dad.jpg","randpic_qq":"","randpic_2":"","randpic_iphone6":"","special_type":0,"ipad_desc":"有待14","is_publish":"111111"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/h5pc/spec_detail?id=212&columnid=88","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149033459416cbfe8213ec7611250fefd710345cca.jpg","randpic_ios5":"","randpic_desc":"","randpic_ipad":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1490334599d227a49dc9f34cb328009c798b092a3f.jpg","randpic_qq":"","randpic_2":"","randpic_iphone6":"","special_type":0,"ipad_desc":"在云端12","is_publish":"111111"},{"type":12,"mo_type":9,"code":"http://music.baidu.com/discuss/detail/1428","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_14901787379fa067a9d950041f3b5046a57958eb15.jpg","randpic_ios5":"","randpic_desc":"","randpic_ipad":"","randpic_qq":"","randpic_2":"","randpic_iphone6":"","special_type":0,"ipad_desc":"","is_publish":"111111"},{"type":2,"mo_type":2,"code":"539747700","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_149026584187c45641c64ab0d0163ad3efe17431b7.jpg","randpic_ios5":"","randpic_desc":"","randpic_ipad":"","randpic_qq":"","randpic_2":"","randpic_iphone6":"","special_type":0,"ipad_desc":"","is_publish":"111111"},{"type":6,"mo_type":4,"code":"http://music.baidu.com/cms/webview/bigwig/vote_zb/index.html?liveid=lss-hbsv2v1u6hxjnwan","randpic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757750884583297d922fbfd86ee2ae967a2797d.jpg","randpic_ios5":"","randpic_desc":"2017说唱歌曲创作大赛","randpic_ipad":"","randpic_qq":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757753083228022b5038d4d427ca758a829e7f1.jpg","randpic_2":"bos_client_148757751402f8f5351322e295beee7fe5579ab828","randpic_iphone6":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_148757751402f8f5351322e295beee7fe5579ab828.jpg","special_type":0,"ipad_desc":"2017说唱歌曲创作大赛","is_publish":"111111"}]
     * error_code : 22000
     */


    private int error_code;
    private List<PicBean> pic;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<PicBean> getPic() {
        return pic;
    }

    public void setPic(List<PicBean> pic) {
        this.pic = pic;
    }

    public static class PicBean {
        @Override
        public String toString() {
            return "PicBean{" +
                    "type=" + type +
                    ", mo_type=" + mo_type +
                    ", code='" + code + '\'' +
                    ", randpic='" + randpic + '\'' +
                    ", randpic_ios5='" + randpic_ios5 + '\'' +
                    ", randpic_desc='" + randpic_desc + '\'' +
                    ", randpic_ipad='" + randpic_ipad + '\'' +
                    ", randpic_qq='" + randpic_qq + '\'' +
                    ", randpic_2='" + randpic_2 + '\'' +
                    ", randpic_iphone6='" + randpic_iphone6 + '\'' +
                    ", special_type=" + special_type +
                    ", ipad_desc='" + ipad_desc + '\'' +
                    ", is_publish='" + is_publish + '\'' +
                    '}';
        }

        /**
         * type : 2
         * mo_type : 2
         * code : 539733222
         * randpic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14901972576967f381036a401fefbe4b1dfd2c185b.jpg
         * randpic_ios5 :
         * randpic_desc :
         * randpic_ipad : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1490197262e4f73fe8bec5e754a10eaeeccb0acaf3.jpg
         * randpic_qq : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14901972806e3724bf7c5213b8110b6ebe07c24ec7.jpg
         * randpic_2 :
         * randpic_iphone6 :
         * special_type : 0
         * ipad_desc : 独家首发4天
         * is_publish : 111111
         */

        private int type;
        private int mo_type;
        private String code;
        private Object randpic;
        private String randpic_ios5;
        private String randpic_desc;
        private String randpic_ipad;
        private String randpic_qq;
        private String randpic_2;
        private String randpic_iphone6;
        private int special_type;
        private String ipad_desc;
        private String is_publish;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getMo_type() {
            return mo_type;
        }

        public void setMo_type(int mo_type) {
            this.mo_type = mo_type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getRandpic() {
            return randpic;
        }

        public void setRandpic(Object randpic) {
            this.randpic = randpic;
        }

        public String getRandpic_ios5() {
            return randpic_ios5;
        }

        public void setRandpic_ios5(String randpic_ios5) {
            this.randpic_ios5 = randpic_ios5;
        }

        public String getRandpic_desc() {
            return randpic_desc;
        }

        public void setRandpic_desc(String randpic_desc) {
            this.randpic_desc = randpic_desc;
        }

        public String getRandpic_ipad() {
            return randpic_ipad;
        }

        public void setRandpic_ipad(String randpic_ipad) {
            this.randpic_ipad = randpic_ipad;
        }

        public String getRandpic_qq() {
            return randpic_qq;
        }

        public void setRandpic_qq(String randpic_qq) {
            this.randpic_qq = randpic_qq;
        }

        public String getRandpic_2() {
            return randpic_2;
        }

        public void setRandpic_2(String randpic_2) {
            this.randpic_2 = randpic_2;
        }

        public String getRandpic_iphone6() {
            return randpic_iphone6;
        }

        public void setRandpic_iphone6(String randpic_iphone6) {
            this.randpic_iphone6 = randpic_iphone6;
        }

        public int getSpecial_type() {
            return special_type;
        }

        public void setSpecial_type(int special_type) {
            this.special_type = special_type;
        }

        public String getIpad_desc() {
            return ipad_desc;
        }

        public void setIpad_desc(String ipad_desc) {
            this.ipad_desc = ipad_desc;
        }

        public String getIs_publish() {
            return is_publish;
        }

        public void setIs_publish(String is_publish) {
            this.is_publish = is_publish;
        }
    }
}
