package org.polytech.projetjanvier.webservice.data.dao;

import org.polytech.projetjanvier.webservice.data.dao.entities.SensorInfo;
import org.polytech.projetjanvier.webservice.data.dao.entities.Station;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import java.util.List;

/**
 * Created by teffaha on 1/20/14.
 */
public class DataAccessLayer implements  DataAdapter{
    private static DataAccessLayer instance;

    /**
     * Get the unique instance of the Dao
     * @return the dao instance
     */
    public static DataAccessLayer getInstance(){
        if(instance == null){
            instance = new DataAccessLayer();
        }
        return instance;
    }


    private DataAdapter dataAdapter;



    private DataAccessLayer(){
        this.dataAdapter = new MySqlAdapter();
    }

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
    public SensorInfo insertSensor(int stationID, int type,int wakeUpPeriod ,float stateOfCharge, float temperature, float RSSI,double timestamp) {
        return null;
    }

	@Override
	public Station insertBeacon(int siteID, String description) {
		return null;
	}
}
