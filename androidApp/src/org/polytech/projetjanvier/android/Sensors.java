package org.polytech.projetjanvier.android;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import org.polytech.projetjanvier.android.adapters.SensorAdapter;
import org.polytech.projetjanvier.android.entities.Sensor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by teffaha on 1/30/14.
 */
public class Sensors extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.station,
                container, false);


        Random rand =  new Random();
        ArrayList<Sensor> lsSensors = new ArrayList<Sensor>();
        for(int i=0;i<5;i++){
            lsSensors.add(new Sensor(i,rand.nextInt(90),rand.nextInt(90),rand.nextInt(90)));
        }

        GridView gv = (GridView)view.findViewById(R.id.listSensors);
        gv.setAdapter(new SensorAdapter(view.getContext(),0,lsSensors));
        return view;
    }





}
