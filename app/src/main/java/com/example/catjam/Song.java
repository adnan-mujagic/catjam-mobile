package com.example.catjam;

public class Song {
    private int imageResId; // the cover of the song
    private String coverUrl = ""; // in case the cover is loaded from URL
    private String name;
    private String artist;
    private String duration = "0:00";
    // private String lyrics = null;


    public Song(int imageResId, String name, String artist) {
        this.imageResId = imageResId;
        this.name = name;
        this.artist = artist;
    }

    public Song(String coverUrl, String name, String artist) {
        this.coverUrl = coverUrl;
        this.name = name;
        this.artist = artist;
    }

    public Song(){

    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
