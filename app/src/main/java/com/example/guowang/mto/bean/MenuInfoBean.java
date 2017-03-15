package com.example.guowang.mto.bean;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class MenuInfoBean {
    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int ImageId;
    private String name;

    public MenuInfoBean(int imageId, String name) {
        ImageId = imageId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MenuInfoBean{" +
                "ImageId=" + ImageId +
                ", name='" + name + '\'' +
                '}';
    }
}
