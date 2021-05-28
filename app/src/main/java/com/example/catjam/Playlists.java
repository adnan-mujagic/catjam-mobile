package com.example.catjam;

import java.util.ArrayList;

public class Playlists {
    private int imageResId;
    private String title;
    private String description;
    private ArrayList<Song> songs;

    public Playlists(int imageResId, String title, String description, ArrayList<Song> songs) {
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.songs = songs;
    }

    public Playlists() {

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
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
