package org.polytech.projetjanvier.webservice.data.dao;

import org.polytech.projetjanvier.webservice.data.dao.entities.SensorInfo;
import org.polytech.projetjanvier.webservice.data.dao.entities.Station;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import java.util.List;

/**
 * Created by teffaha on 1/22/14.
 *
 * Interface defining a DataAdapter (defines how to manage data persistence)
 */
public interface DataAdapter {
    List<Site> selectSites();
    List<Station> selectBeacons(int siteID);
    List<SensorInfo> selectSensors(int beaconID);

    Site insertSite(String description);
    Station insertBeacon(int siteID);
    SensorInfo insertSensor(int beaconID,int type,float stateOfCharge,float temperature,float RSSI);

    /*
            TODO add search capability and a more robust CRUD system
     */
}
