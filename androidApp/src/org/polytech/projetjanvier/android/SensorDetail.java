package org.polytech.projetjanvier.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import org.polytech.projetjanvier.android.adapters.SensorAdapter;
import org.polytech.projetjanvier.android.entities.Sensor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by teffaha on 1/31/14.
 */
public class SensorDetail extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_detail);

        // Return Button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    /**
     * Averloaded to allow back return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }


    private class SensorFetcher extends AsyncTask<Integer, Void, ArrayList<Sensor>>
    {

        public ListView gridView;
        public Context context;

        public SensorFetcherCallback callback;






        @Override
        protected ArrayList<Sensor> doInBackground(Integer... integers) {

            ArrayList<Sensor> lsSites = new ArrayList<Sensor>();
            XMLParser parser = new XMLParser();
            String xml ="";
            try{

                xml = parser.getXmlFromUrl(getString(R.string.URLgetOneSensorsInfo)+integers[0]);
            }catch(Exception exp){

            }
            Document doc = parser.getDomElement(xml);

            NodeList nl = doc.getElementsByTagName("sensorinfo");


            for(int i=0;i<nl.getLength();i++){
                Element e =(Element)nl.item(i);

                int id =0;
                int type =0;
                int period =0;
                int charge =0;;
                int temp =0;
                int rssi =0;
                try{
                    id = Integer.parseInt(parser.getValue(e,"id"));
                    type = Integer.parseInt(parser.getValue(e,"type"));
                    period = Integer.parseInt(parser.getValue(e,"period"));
                    charge = Integer.parseInt(parser.getValue(e,"charge"));
                    temp = Integer.parseInt(parser.getValue(e,"temp"));
                    rssi = Integer.parseInt(parser.getValue(e,"rssi"));
                }catch(NumberFormatException nfe){

                }

                lsSites.add(new Sensor(id,temp,charge,rssi,period));

            }

            return lsSites;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(ArrayList<Sensor> list) {
            gridView.setAdapter(new SensorAdapter(context,0,list));
        }
    }
}