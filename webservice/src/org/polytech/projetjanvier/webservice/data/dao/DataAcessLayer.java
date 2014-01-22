package org.polytech.projetjanvier.webservice.data.dao;

import org.polytech.projetjanvier.webservice.data.dao.entities.Beacon;
import org.polytech.projetjanvier.webservice.data.dao.entities.Sensor;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import java.util.List;

/**
 * Created by teffaha on 1/20/14.
 */
public class DataAcessLayer implements  DataAdapter{
    private static DataAcessLayer instance;

    /**
     * Get the unique instance of the Dao
     * @return the dao instance
     */
    public static DataAcessLayer getInstance(){
        if(instance == null){
            instance = new DataAcessLayer();
        }
        return instance;
    }


    private DataAdapter dataAdapter;



    private DataAcessLayer(){
        this.dataAdapter = new MySqlAdapter();
    }

    @Override
    public List<Site> selectSites() {
        return null;
    }

    @Override
    public List<Beacon> selectBeacons(int siteID) {
        return null;
    }

    @Override
    public List<Sensor> selectSensors(int beaconID) {
        return null;
    }

    @Override
    public Site insertSite(String description) {
        return null;
    }

    @Override
    public Beacon insertBeacon(int siteID) {
        return null;
    }

    @Override
    public Sensor insertSensor(int beaconID, int type, float stateOfCharge, float temperature, float RSSI) {
        return null;
    }
}
