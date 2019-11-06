package com.example.gebeya_mood.AppIntroduction;

public class IntroScreenItem {

    String title, describtion;
    int image;


    public IntroScreenItem(String title, String describtion, int image) {
        this.title = title;
        this.describtion = describtion;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
