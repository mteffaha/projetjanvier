package org.polytech.projetjanvier.webservice.data.dao;

import org.polytech.projetjanvier.webservice.data.dao.entities.Beacon;
import org.polytech.projetjanvier.webservice.data.dao.entities.Sensor;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import java.util.List;

/**
 * Created by teffaha on 1/22/14.
 *
 * Interface defining a DataAdapter (defines how to manage data persistence)
 */
public interface DataAdapter {
    List<Site> selectSites();
    List<Beacon> selectBeacons(int siteID);
    List<Sensor> selectSensors(int beaconID);

    Site insertSite(String description);
    Beacon insertBeacon(int siteID);
    Sensor insertSensor(int beaconID,int type,float stateOfCharge,float temperature,float RSSI);

    /*
            TODO add search capability and a more robust CRUD system
     */
}
