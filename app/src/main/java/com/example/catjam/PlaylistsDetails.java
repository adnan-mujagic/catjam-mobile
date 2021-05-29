package com.example.catjam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistsDetails extends AppCompatActivity {
    public static final String EXTRA_COVER = "EXTRA_COVER";
    public static final String EXTRA_COVER_URL = "EXTRA_COVER_URL";
    public static final String EXTRA_SONG_NAME = "EXTRA_SONG_NAME";
    public static final String EXTRA_ARTIST_NAME = "EXTRA_ARTIST_NAME";

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

            getSongs();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Song song = (Song) parent.getItemAtPosition(position);
                    Intent intent = new Intent(getBaseContext(), SongDetails.class);


                    intent.putExtra(EXTRA_COVER, song.getImageResId());
                    intent.putExtra(EXTRA_COVER_URL, song.getCoverUrl());
                    intent.putExtra(EXTRA_SONG_NAME, song.getName());
                    intent.putExtra(EXTRA_ARTIST_NAME, song.getArtist());

                    // TODO: 27. 5. 2021. put song array into intent here
                    startActivity(intent);
                }
            });

        }
    }


    // This is temporary, need to implement Parcelable interface
    // to pass the ArrayList of songs from the PlaylistFragment
    /*private ArrayList<Song> getSongs(){
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("https://upload.wikimedia.org/wikipedia/bs/b/b2/Metallica_-_Master_of_Puppets_cover.jpg", "Song1", "Amar"));
        songs.add(new Song(R.drawable.playlist1, "Song2", "Ado"));
        songs.add(new Song(R.drawable.playlist3, "Song3", "JLopez"));

        return songs;
    }*/

    public void getSongs(){
        Call<List<Song>> listCall = RetrofitProvider.getInstance().getAllSongs();

        listCall.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                if(response.isSuccessful()){
                    List<Song> songs = response.body();
                    SongListViewAdapter adapter = new SongListViewAdapter(songs, PlaylistsDetails.this);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}