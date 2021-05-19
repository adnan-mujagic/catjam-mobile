package com.example.catjam;

public class Playlists {
    private int imageResId;
    private String title;
    private String description;

    public Playlists(int imageResId, String title, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
    }

    public Playlists() {

    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
