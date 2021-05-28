package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsDetails extends AppCompatActivity {
    ImageView playlistImage;
    TextView playlistTitle, playlistDescription;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists_details);
        playlistImage = findViewById(R.id.playlist_details_image);
        playlistTitle = findViewById(R.id.playlist_details_title);
        playlistDescription = findViewById(R.id.playlist_details_description);

        listView = findViewById(R.id.song_list_view);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            setTitle(extras.getString(PlaylistsFragment.EXTRA_TITLE));
            playlistTitle.setText(extras.getString(PlaylistsFragment.EXTRA_TITLE));
            playlistImage.setImageResource(extras.getInt(PlaylistsFragment.EXTRA_IMAGE));
            playlistDescription.setText(extras.getString(PlaylistsFragment.EXTRA_DESCRIPTION));

            SongListViewAdapter songListViewAdapter = new SongListViewAdapter(getSongs(), getBaseContext());
            listView.setAdapter(songListViewAdapter);

            // TODO: make this item Click listener when clicked on a song
            /*
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Song song = (Song) parent.getItemAtPosition(position);
                    Intent intent = new Intent(getActivity(), SongDetails.class);


                    // TODO: 27. 5. 2021. put song array into intent here
                    startActivity(intent);
                }
            })
            */
        }
    }


    // This is temporary, need to implement Parcelable interface
    // to pass the ArrayList of songs from the PlaylistFragment
    private ArrayList<Song> getSongs(){
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.playlist1, "Song1", "Amar"));
        songs.add(new Song(R.drawable.playlist1, "Song2", "Ado"));
        songs.add(new Song(R.drawable.playlist3, "Song3", "JLopez"));

        return songs;
    }
}