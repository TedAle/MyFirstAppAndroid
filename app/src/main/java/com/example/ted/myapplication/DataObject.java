package com.example.ted.myapplication;

/**
 * Created by Ted on 02/03/2016.
 */
public class DataObject {
    private String name;
    private String detail;
    private int icon;
    private Boolean favorite;
    private int bigImage;

    DataObject(String text1, String text2) {
        this.name = text1;
        this.detail = text2;
        this.icon = R.mipmap.default_icon;
        this.favorite = Boolean.FALSE;
        this.bigImage = R.color.colorPrimary;
    }

    DataObject(String text1, String text2, Boolean favorite) {
        this.name = text1;
        this.detail = text2;
        this.icon = R.mipmap.default_icon;
        this.favorite = favorite;
        this.bigImage = R.mipmap.default_big_image;
    }

    DataObject(String text1, String text2, int icon, Boolean favorite) {
        this.name = text1;
        this.detail = text2;
        this.icon = icon;
        this.favorite = favorite;
        this.bigImage = R.mipmap.default_big_image;
    }

    DataObject(String text1, String text2, int icon, Boolean favorite, int bigImage) {
        this.name = text1;
        this.detail = text2;
        this.icon = icon;
        this.favorite = favorite;
        this.bigImage = bigImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getFavorite() {
        return this.favorite;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return this.icon;
    }

    public int getBigImage() {
        return this.bigImage;
    }

    public void setBigImage(int bigImage) {
        this.bigImage = bigImage;
    }
}
