package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SongDetails extends AppCompatActivity {
    ImageView coverImage;
    TextView songName, artistName;
    Button playButton;

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
            coverImage.setImageResource(extras.getInt(PlaylistsDetails.EXTRA_COVER));
            songName.setText(extras.getString(PlaylistsDetails.EXTRA_SONG_NAME));
            artistName.setText(extras.getString(PlaylistsDetails.EXTRA_ARTIST_NAME));


        }
    }

    // TODO: 28. 5. 2021. make this function for play button
    /*public static onButtonPlay(View view){

    }*/


}