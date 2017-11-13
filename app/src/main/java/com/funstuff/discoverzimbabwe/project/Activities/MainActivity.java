package com.funstuff.discoverzimbabwe.project.Activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.funstuff.discoverzimbabwe.project.Fragments.ActivitiesFragment;
import com.funstuff.discoverzimbabwe.project.Fragments.HotelsFragment;
import com.funstuff.discoverzimbabwe.project.Fragments.PlaceFragment;
import com.funstuff.discoverzimbabwe.project.Adapters.MyFragPagerAdapter;
import com.funstuff.discoverzimbabwe.project.R;
import com.funstuff.discoverzimbabwe.project.Recycler.Album;
import com.funstuff.discoverzimbabwe.project.about;
import com.funstuff.discoverzimbabwe.project.favorite;

import java.util.ArrayList;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Context c;
    ArrayList<Album> albums;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //this is were we setup the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this is were we setup the viewpager.
        ViewPager vp = (ViewPager) findViewById(R.id.mViewpager_ID);
        this.addPages(vp);

        //this is were we manage the size of the tablayout thus "should it cover the whole screen
        //when in landscape mode or not"
        TabLayout tabLayout = (TabLayout) findViewById(R.id.mtab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(listener(vp));

        //This is were we setup icons and the number of tabs on the actionbar
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_place_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_hotel_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_local_activity_black_24dp);


        //This is were we manage the drawer_layout and its toggle button whether the
        //to open or close the drawer.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //This is were we manage itemclicks on the side navigation drawer.
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // This is wer we add all fragments to the viewPager
    private void addPages(ViewPager pager) {
        MyFragPagerAdapter adapter = new MyFragPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PlaceFragment());
        adapter.addFragment(new HotelsFragment());
        adapter.addFragment(new ActivitiesFragment());
        pager.setAdapter(adapter);
    }

    //WE control the tabs thus the viewpager should return the selected tab.
    private TabLayout.OnTabSelectedListener listener(final ViewPager pager) {
        return new TabLayout.OnTabSelectedListener() {

            //Here we return the current tab thus if a tab is pressed the
            // view will change to that tablayout.
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
                  }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                          }
        };
    }

    @Override
    //Here we manage the position of the navigation drawer thus when the drawer is closed
    // it should mantain its gravity to Start ,thus should be out of sight and confined to
    // the far left side of the screen.
     public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

        @Override
           public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
                  }

      @Override
         public boolean onOptionsItemSelected(MenuItem item) {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          int id = item.getItemId();

          //noinspection SimplifiableIfStatement
          if (id == R.id.about) {
              Intent intent = new Intent(this, about.class);
              startActivity(intent);
          }
          return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    //this is were we control the navigation drawer menu buttons
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        // int id = item.getItemId();
        if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, favorite.class);
            //intent.putExtra(Intent.EXTRA_TEXT, albums.get(pos).getImage());
            // startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }}


