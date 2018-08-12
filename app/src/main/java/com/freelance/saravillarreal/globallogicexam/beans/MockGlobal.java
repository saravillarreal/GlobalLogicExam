package com.freelance.saravillarreal.globallogicexam.beans;

import android.support.annotation.Nullable;

import java.io.Serializable;

public class MockGlobal implements Serializable{

    private String title;
    private String description;
    private String image;

    public MockGlobal(@Nullable String title, @Nullable String description, @Nullable String imageUrl) {
        this.title = title;
        this.description = description;
        this.image = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
