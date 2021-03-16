package com.billy.oceanslotmachinesearoute.Model;

public class AdviceFishModel {
  String title;
  String desc;
  Integer image;

    public AdviceFishModel(String title, String desc,Integer img) {
        this.title = title;
        this.desc = desc;
        this.image = img;
    }

    public Integer getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
