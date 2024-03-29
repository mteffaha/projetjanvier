package org.polytech.projetjanvier.webservice.service;
import org.polytech.projetjanvier.webservice.data.dao.entities.SensorInfo;
import org.polytech.projetjanvier.webservice.data.dao.entities.Station;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * @author teffaha
 * Service contract for the nodeman web service wich handles communications between sensor nodes and their corresponding monitors
 *
 */
@WebService()
public class nodeman {


    /**
     * Returns the list of all available sites
     *
     * @return the list of all available sites
     */
  @WebMethod
  public List<Site> getListSites(){
      ArrayList<Site> listSites= new ArrayList<Site>();
      for(int i=0;i<10;i++){
          Site  s =  new Site(i,"Site : "+i);
          listSites.add(s);
      }
      return listSites;
  }


    /**
     * List all available beacon in a given site
     * @param siteID  the requested site
     * @return list of available beacon in the given site
     */
  @WebMethod
  public List<Station> getListBeasons(@WebParam(name ="siteID") int siteID){
      return new ArrayList<Station>();
  }

    /**
     * List of all connected sensor to a given beacon
     * this list will give the lastest instance of the sensors if the sensor is not higher that the ignoreRate
     * whose latestet value can be found in the documentaion of the project
     *
     * @param beaconID the id of the beacon to which the sensors are connected
     * @return the latest instance of the sensor connected to beacon passed as parameter
     */
  @WebMethod
  public List<SensorInfo> getListSensors(@WebParam(name ="beaconID")int beaconID){
      return new ArrayList<SensorInfo>();
  }

    /**
     * Creates a new site and returns the created site.
     *
     * the newly created site id can be set in the beacon config file to set it as a member of the site
     *
     * @param description a brief textual description of the site created
     * @return the created site
     */
  @WebMethod
  public Site  createSite(@WebParam(name ="description") String description){
      return new Site(0,"DEFAULT");
  }

    /**
     * associates a beacon to a site and gives it a uniq id to be used lated
     * @param siteID the site the which the beacon is associated
     * @return the beacon created
     */
  @WebMethod
  public Station addStation(@WebParam(name ="siteID") int siteID){
      return new Station(0,0,"");
  }

    /**
     * Stores a sensor instance (a timestamp will be added to tell whether this update is recent).
     *
     * @param beaconID  the id of the beacon to which the sensors is connected
     * @param id the id of the beacon(which will also be used to determine to type of the beacon)
     * @param type the type of sensor (solar, Wind Power etc ..)
     * @param wakeUpPeriod Wake up period
     * @param stateOfCharge state of charge of the beacon (determine the amount of power the sensor has)
     * @param temperature temperature as detected by the sensor
     * @param RSSI Recieved Strength Signal Information
     * @return
     */
  @WebMethod
  public SensorInfo updateSensor(@WebParam(name ="stationID")int stationID,
                              @WebParam(name ="sensorID")int id,
                              @WebParam(name ="type")int type,
                              @WebParam(name ="wakeUpPeriod")int wakeUpPeriod,
                              @WebParam(name ="stateOfCharge")float stateOfCharge,
                              @WebParam(name ="temperature")float temperature,
                              @WebParam(name ="RSSI")float RSSI,
                              @WebParam(name ="timestamp") double timestamp){
      return new SensorInfo(stationID, type,wakeUpPeriod ,stateOfCharge, temperature, RSSI,0);
  }

  public static void main(String[] argv) {
    Object implementor = new nodeman ();
    String address = "http://localhost:9000/nodeman";
    Endpoint.publish(address, implementor);
  }
}
