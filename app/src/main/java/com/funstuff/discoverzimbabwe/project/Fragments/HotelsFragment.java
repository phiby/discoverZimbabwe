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

public class HotelsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hotels,null);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.mOnsale);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new MyRecyclerAdapter(this.getActivity(),getOnSaleAlbum()));

        return v;
    }

    //this is were we add content to the PlaceFragment.
    //thus tis is done through the use of ArrayLists.
    private ArrayList<Album> getOnSaleAlbum() {
        // Collection of hotels
        ArrayList<Album> albums = new ArrayList<>();
        Album album = new Album("STANLEY SAFARI LODGE \nLocation: Victoria Falls", R.drawable.stanley);
        albums.add(album);

        album = new Album("TROUTBACK HOTEL \nLocation:  Nyanga", R.drawable.chinhoyicaves);
        albums.add(album);

        album = new Album("CARIBBEA BAY HOTEL \nLocation:  Kariba", R.drawable.caribbea);
        albums.add(album);

        album = new Album("GREAT ZIMBABWE HOTEL \nLocation:  Great Zimbabwe", R.drawable.greatzz);
        albums.add(album);

        album = new Album("HWANGE SAFARI LODGE \nLocation:  Hwange", R.drawable.hwangas);
        albums.add(album);

        return albums;



    }


    //This is were we set the title For the fragment
    public String toString(){
        return "Hotels";
    }




}
