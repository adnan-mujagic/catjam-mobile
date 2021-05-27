package com.example.catjam;

public class Song {
    private String name;
    private String artistName;
    private int coverPhotoId;

    public Song(String name, String artistName, int coverPhotoId) {
        this.name = name;
        this.artistName = artistName;
        this.coverPhotoId = coverPhotoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getCoverPhotoId() {
        return coverPhotoId;
    }

    public void setCoverPhotoId(int coverPhotoId) {
        this.coverPhotoId = coverPhotoId;
    }
}
