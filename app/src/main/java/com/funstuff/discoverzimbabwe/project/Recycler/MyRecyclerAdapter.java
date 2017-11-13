package com.funstuff.discoverzimbabwe.project.Recycler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.funstuff.discoverzimbabwe.project.R;
import com.funstuff.discoverzimbabwe.project.favorite;

import java.util.ArrayList;

/**
 * Created by phiby on 29/10/17.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{

    public static final String PREFS_NAME = "MYPref";

     Context c;
    ArrayList<Album> albums;

    public MyRecyclerAdapter(Context c, ArrayList<Album> albums){
        this.c=c;
        this.albums=albums;
    }
    // This is were we initialize our view holder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        MyViewHolder holder = new MyViewHolder(v);
       return holder;
    }

    //Bind data to our views
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.place.setText(albums.get(position).getName());
      holder.img.setImageResource(albums.get(position).getImage());

     //this is were we setup the on itemClickListener.
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(c.getApplicationContext());
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("favorite",albums.get(pos).getImage());
                editor.commit();

                //A text is shown to the screen whenever an item is clicked by using a Toast.
                Toast.makeText(c,albums.get(pos).getName() + " ,added to favorite ",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(c, favorite.class);
               intent.putExtra(Intent.EXTRA_TEXT, albums.get(pos).getImage());

                PreferenceManager.getDefaultSharedPreferences(c.getApplicationContext());
                c.startActivity(intent);





            }
        });
    }
    @Override
    public int getItemCount() {
        return albums.size();
    }
}
