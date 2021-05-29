package com.example.catjam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubApiService {

    @GET("songs")
    Call<List<Song>> getAllSongs();
}
