package org.polytech.projetjanvier.webservice.data.dao;

import org.polytech.projetjanvier.webservice.data.dao.entities.SensorInfo;
import org.polytech.projetjanvier.webservice.data.dao.entities.Station;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import java.util.List;

/**
 * Created by teffaha on 1/22/14.
 */
public class MySqlAdapter implements DataAdapter {
    @Override
    public List<Site> selectSites() {
        return null;
    }

    @Override
    public List<Station> selectBeacons(int siteID) {
        return null;
    }

    @Override
    public List<SensorInfo> selectSensors(int beaconID) {
        return null;
    }

    @Override
    public Site insertSite(String description) {
        return null;
    }

    @Override
    public Station insertBeacon(int siteID) {
        return null;
    }

    @Override
    public SensorInfo insertSensor(int beaconID, int type, float stateOfCharge, float temperature, float RSSI) {
        return null;
    }
}
