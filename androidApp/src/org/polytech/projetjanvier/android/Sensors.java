package org.polytech.projetjanvier.android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import org.polytech.projetjanvier.android.adapters.SensorAdapter;
import org.polytech.projetjanvier.android.adapters.SiteAdapter;
import org.polytech.projetjanvier.android.entities.Sensor;
import org.polytech.projetjanvier.android.entities.Site;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by teffaha on 1/30/14.
 */
public class Sensors extends Fragment  implements AdapterView.OnItemClickListener , SensorFetcherCallback{

    private Context context;
    private GridView gridView;
    private Handler handler;
    private Runnable runnable;
    private int stationid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.station,
                container, false);


        Bundle args =  getArguments();
        stationid = 0;
        if(args != null){
            stationid =  args.getInt(getString(R.string.arg_statioid),0);
        }

        final SensorFetcherCallback cb = this;

        gridView = (GridView)view.findViewById(R.id.listSensors);
        handler = new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                SensorFetcher fetcher =  new SensorFetcher();
                fetcher.callback =cb;
                fetcher.context = context;
                fetcher.execute(stationid);
                handler.postDelayed(runnable,1000);

            }
        };

        handler.post(runnable);


        gridView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(context, SensorDetail.class);

        startActivity(intent);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    @Override
    public void onSensorsFetched(List<Sensor> sensors) {

            gridView.setAdapter(new SensorAdapter(context,0,sensors));
    }


    private class SensorFetcher extends AsyncTask<Integer, Void, ArrayList<Sensor>>
    {

        public GridView gridView;
        public Context context;

        public SensorFetcherCallback callback;






        @Override
        protected ArrayList<Sensor> doInBackground(Integer... integers) {

            ArrayList<Sensor> lsSites = new ArrayList<Sensor>();
            XMLParser parser = new XMLParser();
            String xml ="";
            try{

            xml = parser.getXmlFromUrl(getString(R.string.URLgetSensorsInfo)+integers[0]);
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
            if(!isAdded()){
                return;
            }
            callback.onSensorsFetched(list);

        }
    }
}