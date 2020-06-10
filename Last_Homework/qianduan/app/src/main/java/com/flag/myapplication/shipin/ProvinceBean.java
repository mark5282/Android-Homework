package com.flag.myapplication.shipin;

import java.io.Serializable;

public class ProvinceBean implements Serializable {

    int id;
    String url;
    String paht;
    String image;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPaht() {
        return paht;
    }

    public void setPaht(String paht) {
        this.paht = paht;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
