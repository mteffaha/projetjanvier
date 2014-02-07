package org.polytech.projetjanvier.android;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.polytech.projetjanvier.android.adapters.SensorAdapter;
import org.polytech.projetjanvier.android.adapters.SiteAdapter;
import org.polytech.projetjanvier.android.adapters.StationAdapter;
import org.polytech.projetjanvier.android.entities.Sensor;
import org.polytech.projetjanvier.android.entities.Site;
import org.polytech.projetjanvier.android.entities.Station;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Sites extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{

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




        Typeface leagueGothic = Typeface.createFromAsset(getAssets(), "fonts/opensans-ebi.ttf");


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

        Fragment fragment =  new HelloFragment();



        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
        // Setting the spinner
        SitesFetcher fetcher =  new SitesFetcher();
        fetcher.spinner =  (Spinner)findViewById(R.id.sitespinner);
        fetcher.spinner.setOnItemSelectedListener(this);

        fetcher.context = this;

        fetcher.execute();


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


        setSensorList(((Station)adapterView.getItemAtPosition(i)).getId());

        drawerLayout.closeDrawer(drawerView);

    }

    private void setSensorList(int id){
        Fragment fragment =  new Sensors();

        Bundle args = new Bundle();
        args.putInt(getString(R.string.arg_statioid),id);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }

    private void setStationList(int id){



        StationFetcher stationFetcher =  new StationFetcher();
        stationFetcher.listView =   (ListView)findViewById(R.id.listStation);
        stationFetcher.context = this;
        stationFetcher.siteid = id;

        stationFetcher.listView.setOnItemClickListener(this);

        stationFetcher.execute();

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Site s = (Site)adapterView.getItemAtPosition(i);
        TextView tv = (TextView)findViewById(R.id.sitedescription);
        tv.setText(s.getDescription());
        tv.invalidate();
        setStationList(s.getId());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private class SitesFetcher extends AsyncTask<String, Void, ArrayList<Site>>
    {

        public Spinner spinner;
        public Context context;

        @Override
        protected ArrayList<Site> doInBackground(String... strings) {
            ArrayList<Site> lsSites = new ArrayList<Site>();
            XMLParser parser = new XMLParser();
            String xml = parser.getXmlFromUrl(getString(R.string.URLgetSites));
            Document doc = parser.getDomElement(xml);

            NodeList nl = doc.getElementsByTagName("site");


            for(int i=0;i<nl.getLength();i++){
                Element e =(Element)nl.item(i);
                int id = Integer.parseInt(parser.getValue(e,"id"));
                String title= parser.getValue(e,"title");
                String description = parser.getValue(e,"description");
                int nbStation = 0;
                lsSites.add(new Site(id, title,description, nbStation));
            }

            return lsSites;
        }

        @Override
        protected void onPreExecute() {
        }

        protected void onPostExecute(ArrayList<Site> list) {
            spinner.setAdapter(new SiteAdapter(context,R.layout.site_element,list));

        }
    }

    private class StationFetcher extends AsyncTask<String, Void, ArrayList<Station>>
    {

        public ListView listView;
        public Context context;
        int siteid;

        @Override
        protected ArrayList<Station> doInBackground(String... strings) {
            ArrayList<Station> lsSites = new ArrayList<Station>();
            XMLParser parser = new XMLParser();


            String xml = parser.getXmlFromUrl(getString(R.string.URLgetStation)+siteid);

            Document doc = parser.getDomElement(xml);

            NodeList nl = doc.getElementsByTagName("station");


            for(int i=0;i<nl.getLength();i++){
                Element e =(Element)nl.item(i);
                int id = Integer.parseInt(parser.getValue(e, "id"));
                String title= parser.getValue(e,"title");
                int nbStation = 0;
                lsSites.add(new Station(id,title,siteid));
            }

            return lsSites;
        }

        @Override
        protected void onPreExecute() {
        }

        protected void onPostExecute(ArrayList<Station> list) {
            listView.setAdapter(new StationAdapter(context,0,list));

        }
    }
}
