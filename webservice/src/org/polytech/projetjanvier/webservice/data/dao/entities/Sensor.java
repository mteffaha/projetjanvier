package org.polytech.projetjanvier.webservice.data.dao.entities;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by teffaha on 1/20/14.
 */
public class Sensor {
    @XmlElement
    public int id;
    @XmlElement
    public int beaconID;
    @XmlElement
    public int type;
    @XmlElement
    public float stateOfCharge;
    @XmlElement
    public float temperature;
    @XmlElement
    public float RSSI;

    public Sensor(int beaconID,int type,float stateOfCharge,float temperature,float RSSI){
        this.beaconID = beaconID;
        this.id = id;
        this.stateOfCharge = stateOfCharge;
        this.temperature = temperature;
        this.RSSI = RSSI;
    }


}
