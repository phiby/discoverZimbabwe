package com.funstuff.discoverzimbabwe.project.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funstuff.discoverzimbabwe.project.R;
import com.funstuff.discoverzimbabwe.project.Recycler.Album;

import com.funstuff.discoverzimbabwe.project.Recycler.MyRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by phiby on 29/10/17.
 */

public class PlaceFragment extends Fragment {

    @Nullable
    @Override
    //This is were we inflte the view through the layout inflater.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_place,null);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.mRecyclerFeatured);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new MyRecyclerAdapter(this.getActivity(),getAlbum()));

        return v;
    }
    //this is were we add content to the PlaceFragment.
    //thus tis is done through the use of ArrayLists.
    private ArrayList<Album> getAlbum() {
        // Collection of places
        ArrayList<Album> albums = new ArrayList<>();
        Album album = new Album("CHIMANIMANI \nLocation:  South of Mutare ", R.drawable.chimanimani);
        albums.add(album);

        album = new Album("CHINHOYI CAVES \nLocation:  NorthWest of Chinhoyi", R.drawable.chinhoyicaves);
        albums.add(album);

        album = new Album("GREAT ZIMBABWE \nLocation:  South East of Masvingo", R.drawable.great);
        albums.add(album);

        album = new Album("HWANGE NATIONAL PARK \nLocation:  West of Bulawayo", R.drawable.hwange);
        albums.add(album);

        album = new Album("KARIBA DAM \nLocation: Between Zimbabwe and Zambia ", R.drawable.kariba);
        albums.add(album);

        album = new Album("MUTARAZI WATERFALL \nLocation: Eastern Highlands", R.drawable.mutarazi);
        albums.add(album);

        album = new Album("NYANGANI MOUNTAINS \nLocation:  Eastern Highlands", R.drawable.nyanga);
        albums.add(album);

        album = new Album("VICTORIA FALLS \nLocation:  Southern Side of Zimbabwe", R.drawable.vicfalls);
        albums.add(album);

        album = new Album("MANA POOLS NATIONAL PARK \nLocation: North of Zimbabwe", R.drawable.manap);
        albums.add(album);

        album = new Album("MATUSADONA NATIONAL PARK \nLocation: Northern Zimbabwe", R.drawable.matusadona);
        albums.add(album);

        album = new Album("MATOBO NATIONAL PARK \nLocation: Southwest Zimbabwe", R.drawable.matobo);
        albums.add(album);


        album = new Album("WORLDVIEW NYANGA \nLocation: Eastern Highlands", R.drawable.worldv);
        albums.add(album);

        return albums;
    }
    //This is were we set the title For the fragment
    public String toString(){
        return "Places";
    }
}
