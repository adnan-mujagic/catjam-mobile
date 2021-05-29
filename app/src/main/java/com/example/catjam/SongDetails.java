package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SongDetails extends AppCompatActivity {
    ImageView coverImage;
    TextView songName, artistName;
    Button playButton;
    private String songUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        coverImage = findViewById(R.id.song_details_cover);
        songName = findViewById(R.id.song_details_song_name);
        artistName = findViewById(R.id.song_details_song_artist);
        playButton = findViewById(R.id.play_button);

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            // if statement where we determine whether the cover image is loaded from
            // local storage of the app, or from the internet

            if(extras.getString(PlaylistsDetails.EXTRA_COVER_URL).isEmpty()){
                coverImage.setImageResource(extras.getInt(PlaylistsDetails.EXTRA_COVER));
            }
            else{
                Glide.with(this).load(extras.getString(PlaylistsDetails.EXTRA_COVER_URL)).into(coverImage);
            }
            songUrl = extras.getString(PlaylistsDetails.EXTRA_SONG_URL);
            songName.setText(extras.getString(PlaylistsDetails.EXTRA_SONG_NAME));
            artistName.setText(extras.getString(PlaylistsDetails.EXTRA_ARTIST_NAME));
        }
    }

    // TODO: 28. 5. 2021. make this function for play button
    public void playFile(View view){
        MediaPlayer mediaPlayer = new MediaPlayer();
        try{
            mediaPlayer.setDataSource(songUrl);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mediaPlayer.prepareAsync();
        } catch(IOException e){
            e.printStackTrace();
        }
    }


}