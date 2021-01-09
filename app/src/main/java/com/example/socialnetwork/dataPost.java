package com.example.socialnetwork;

public class dataPost {
    private int image;
    private String name,time,detail;

    public dataPost(int image, String name, String time, String detail) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.detail = detail;
    }

    public dataPost() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
