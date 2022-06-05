package com.example.newandroid;

import com.google.gson.annotations.SerializedName;

public class Results{
    public class Data{
        String name;
        String author;
        String publishing;
        String published;
    };

    @SerializedName("msg")
    private String message;
    @SerializedName("data")
    private Data datas;

    public Results(String name) {
        this.message = name;
    }

    public String getMsg() {
        return this.message;
    }
    public String getName() {
        return datas.name;
    }
    public String getAuthor() {
        return datas.author;
    }
    public String getPublishing() {
        return datas.publishing;
    }
    public String getPublishTime() {
        return datas.published;
    }
}
