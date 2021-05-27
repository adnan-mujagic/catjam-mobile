package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaylistsDetails extends AppCompatActivity {
    ImageView playlistImage;
    TextView playlistTitle, playlistDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists_details);
        playlistImage = findViewById(R.id.playlist_details_image);
        playlistTitle = findViewById(R.id.playlist_details_title);
        playlistDescription = findViewById(R.id.playlist_details_description);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            setTitle(extras.getString(PlaylistsFragment.EXTRA_TITLE));
            playlistTitle.setText(extras.getString(PlaylistsFragment.EXTRA_TITLE));
            playlistImage.setImageResource(extras.getInt(PlaylistsFragment.EXTRA_IMAGE));
            playlistDescription.setText(extras.getString(PlaylistsFragment.EXTRA_DESCRIPTION));
        }

    }
}