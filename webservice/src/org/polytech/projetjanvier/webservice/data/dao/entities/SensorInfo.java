package org.polytech.projetjanvier.webservice.data.dao.entities;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by teffaha on 1/20/14.
 */
public class SensorInfo {
    @XmlElement
    public int id;
    @XmlElement
    public int stationID;
    @XmlElement
    public int type;
    @XmlElement
    public int wakeUpPeriod;
    @XmlElement
    public float stateOfCharge;
    @XmlElement
    public float temperature;
    @XmlElement
    public float RSSI;
    @XmlElement
    public double timestamp;


    //(stationID, type,wakeUpPeriod ,stateOfCharge, temperature, RSSI)
    public SensorInfo(int stationID, int type,int wakeUpPeriod ,float stateOfCharge, float temperature, float RSSI,double timestamptitl){
        this.stationID = stationID;
        this.id = id;
        this.stateOfCharge = stateOfCharge;
        this.temperature = temperature;
        this.RSSI = RSSI;
        this.type = type;
        this.wakeUpPeriod = wakeUpPeriod;
        this.timestamp = timestamp;

    }


}
