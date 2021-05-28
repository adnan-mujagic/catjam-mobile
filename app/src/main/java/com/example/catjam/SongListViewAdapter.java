package com.example.catjam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SongListViewAdapter extends BaseAdapter {

    private List<Song> songs;
    private Context context;

    public SongListViewAdapter(List<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return songs.indexOf(songs.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.songs_list_view_item, parent,false);
        Song song = songs.get(position);

        ImageView songCoverImageView = convertView.findViewById(R.id.song_cover);
        TextView songNameTextView = convertView.findViewById(R.id.song_name);
        TextView artistTextView = convertView.findViewById(R.id.artist_name);
        TextView durationTextView = convertView.findViewById(R.id.duration);

        // checking if cover is URL or local
        if(song.getCoverUrl().isEmpty()){
            songCoverImageView.setImageResource(song.getImageResId());
        }
        else{
            Glide.with(context).load(song.getCoverUrl()).into(songCoverImageView);
        }

        songNameTextView.setText(song.getName());
        artistTextView.setText(song.getArtist());
        durationTextView.setText(song.getDuration());

        return convertView;
    }
}
