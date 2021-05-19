package com.example.catjam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class PlaylistsFragment extends Fragment {
    private ListView listView;
    String[] months;
    List<Playlists> playlists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlists, container, false);

        ListView listView = (ListView) view.findViewById(R.id.list_view_container);

        PlaylistsListViewAdapter playlistsListViewAdapter = new PlaylistsListViewAdapter(getPlaylists(), getActivity());
        listView.setAdapter(playlistsListViewAdapter);
/*
        PlaylistsListViewAdapter playlistsListViewAdapter = PlaylistsListViewAdapter(playlists, )
*/
        return view;

    }

    private List<Playlists> getPlaylists(){
        List<Playlists> playlistsList = new ArrayList<>();
        playlistsList.add(new Playlists(R.drawable.playlist1, "Playlist1", "Jazz"));

        playlistsList.add(new Playlists(R.drawable.playlist1, "Playlist2", "Chill"));

        playlistsList.add(new Playlists(R.drawable.playlist3, "Playlist3", "Top50"));

        return playlistsList;
    }
}
