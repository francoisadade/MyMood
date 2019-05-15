package com.example.francoisadade.mymood;

import java.io.Serializable;
import java.util.Date;

public class Mood implements Serializable {
    private int id;
    private int color;
    private String comment;
    private Date mDate;
    private float width;

    public Mood(int id, int color, String comment, Date date) {
        this.id = id;
        this.color = color;
        this.comment = comment;
        mDate = date;
    }

    public Mood(int color, String comment, Date date) {
        this.color = color;
        this.comment = comment;
        mDate = date;
    }

    public Mood(int color, String comment, Date date, float width) {
        this.color = color;
        this.comment = comment;
        mDate = date;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        setWidth(getDimenssion(color));
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    float getDimenssion(int couleur){
        float value = 0;
        switch (couleur){
            case R.color.faded_red:
                value = 0.2F;
                break;
            case R.color.banana_yellow:
                value = 1;
                break;
            case R.color.light_sage:
                value = 0.8F;
                break;
            case R.color.warm_grey:
                value = 0.4F;
                break;
            case R.color.cornflower_blue_65:
                value = 0.6F;
                break;
        }

        return value;
    }
}
