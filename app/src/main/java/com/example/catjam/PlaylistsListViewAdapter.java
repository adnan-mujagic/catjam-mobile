package com.example.catjam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaylistsListViewAdapter extends BaseAdapter {

    private List<Playlists> playlistsList;
    private Context context;

    public PlaylistsListViewAdapter(List<Playlists> playlistsList, Context context) {
        this.playlistsList = playlistsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return playlistsList.size();
    }

    @Override
    public Object getItem(int position) {
        return playlistsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return playlistsList.indexOf(playlistsList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_list_view_item, parent,false);
        Playlists playlist = playlistsList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView titleTextView = convertView.findViewById(R.id.item_title);
        TextView descriptionTextView = convertView.findViewById(R.id.item_description);

        imageView.setImageResource(playlist.getImageResId());
        titleTextView.setText(playlist.getTitle());
        descriptionTextView.setText(playlist.getDescription());

        return convertView;
    }
}
