package com.example.guowang.mto.bean;

import java.io.Serializable;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class MusicInfoBean implements Serializable {


    /**
     * type : 2
     * mo_type : 2
     * code : 538777110
     * randpic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1489679279c869c1cf24e6f0cbc116365452f04df9.jpg
     * randpic_ios5 :
     * randpic_desc :
     * randpic_ipad : http://business.cdn.qianqian.com/qianqian/pic/bos_client_14896792844860ae64207bec82ae623d78b4d9ca55.jpg
     * randpic_qq : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1489679289c8aed3c31aba9e8baa12a6d86f869818.jpg
     * randpic_2 :
     * randpic_iphone6 :
     * special_type : 0
     * ipad_desc : 薛之谦
     * is_publish : 111111
     */

    private int type;
    private int mo_type;
    private String code;
    private String randpic;
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

    public String getRandpic() {
        return randpic;
    }

    public void setRandpic(String randpic) {
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

    @Override
    public String toString() {
        return "MusicInfoBean{" +
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
}
