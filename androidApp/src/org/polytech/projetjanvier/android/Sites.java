package org.polytech.projetjanvier.android;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import org.polytech.projetjanvier.android.adapters.SensorAdapter;
import org.polytech.projetjanvier.android.adapters.StationAdapter;
import org.polytech.projetjanvier.android.entities.Sensor;
import org.polytech.projetjanvier.android.entities.Station;

import java.util.ArrayList;
import java.util.Random;

public class Sites extends Activity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private String appTitle;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);




        Typeface leagueGothic = Typeface.createFromAsset(getAssets(), "fonts/leaguegothic.otf");
        TextView siteid = (TextView)findViewById(R.id.siteid);
        ListView listStation = (ListView)findViewById(R.id.listStation);
        siteid.setTypeface(leagueGothic);
        drawerView = (View)findViewById(R.id.drawer_list);


        // Handling Navigation drawer

        // Letting the app icon start the navigation drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        appTitle = getTitle().toString();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_drawer,R.string.open_menu,R.string.close_menu){
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(appTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(appTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);

        /*
                Filling the site list with dummy data
         */
        ArrayList<Station> stations =  new ArrayList<Station>();
        for(int i=0;i<4;i++){
            stations.add(new Station(i,0));
        }
        listStation.setAdapter(new StationAdapter(this,0,stations));

        listStation.setOnItemClickListener(this);

        // Setting default view
        setSensorList(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       /* Intent myIntent = new Intent(this, SensorActivity.class);
        myIntent.putExtra("key", 10); //Optional parameters
        this.startActivity(myIntent);
        */

        // Starting Sensor fragment
        setSensorList(0);

        drawerLayout.closeDrawer(drawerView);

    }

    private void setSensorList(int id){
        Fragment fragment =  new Sensors();
        /*
        Bundle args = new Bundle();
    args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
    fragment.setArguments(args);
         */
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }
}
