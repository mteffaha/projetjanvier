package org.polytech.projetjanvier.android.entities;

import org.polytech.projetjanvier.android.SensorComponent;
import org.polytech.projetjanvier.android.SensorUpdate;

/**
 * Created by teffaha on 1/29/14.
 */
public class Sensor {

    private int id;
    private int temperature;
    private int soc;
    private int rssi;

    private SensorUpdate listener;


    public Sensor(int id,int temperature,int soc,int rssi){
        this.id=id;
        this.temperature = temperature;
        this.soc = soc;
        this.rssi = rssi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
        if(listener != null){
            listener.updateSensor(this);
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        if(listener != null){
            listener.updateSensor(this);
        }
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
        if(listener != null){
            listener.updateSensor(this);
        }
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
        if(listener != null){
            listener.updateSensor(this);
        }
    }

    public void synchronizeValues(){
        setId(getId());
        setRssi(getRssi());
        setSoc(getSoc());
        setTemperature(getTemperature());
    }

    public void setListener(SensorUpdate listener) {
        this.listener = listener;
    }
}
