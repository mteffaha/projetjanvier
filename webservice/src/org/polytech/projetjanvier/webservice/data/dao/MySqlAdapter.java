package org.polytech.projetjanvier.webservice.data.dao;

import org.polytech.projetjanvier.webservice.data.dao.entities.SensorInfo;
import org.polytech.projetjanvier.webservice.data.dao.entities.Station;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by teffaha on 1/22/14.
 */
public class MySqlAdapter implements DataAdapter {

        public static final String DB_LOC = "webservice/database.db";
        public static final boolean DEBUG = true;

        private Connection _connection;

        public MySqlAdapter() {
                try {
                        Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                }
        }
        
        public static void trace(String s) {
                if(DEBUG) {
                        System.out.println(s);
                }
        }

        public void openConnection(String path) {
                if(_connection==null) {
                        try {
                                _connection = DriverManager.getConnection("jdbc:sqlite:"+path);
                        } catch(SQLException e) {
                                System.err.println(e.getMessage());
                        }
                }
        }

        public void openConnection() {
                openConnection(DB_LOC);
        }

        public void closeConnection() {
                if(_connection != null) {
                        try {
                                _connection.close();
                        } catch(SQLException e) {
                                System.err.println(e);
                        }
                }
        }

        public void initDB() {
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);
                        statement.executeUpdate("drop table if exists info");
                        statement.executeUpdate("drop table if exists stations");
                        statement.executeUpdate("drop table if exists sites");
                        statement.executeUpdate("create table sites (" +
                                        "id integer primary key autoincrement," +
                                        "desc string" +
                                        ")");
                        statement.executeUpdate("create table stations (" +
                                        "id integer primary key autoincrement," +
                                        "site_id integer references sites," +
                                        "desc string" +
                                        ")");
                        statement.executeUpdate("create table info (" +
                                        "station_id integer references stations," +
                                        "type integer," +
                                        "period integer," +
                                        "charge float," +
                                        "temp float," +
                                        "rssi float," +
                                        "timestamp double" +
                                        ")");
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public List<Site> selectSites() {
                List<Site> sites = new ArrayList<Site>();
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.
                        ResultSet rs = statement.executeQuery("select * from sites");
                        while(rs.next())
                        {
                                Site s = new Site(rs.getInt("id"),rs.getString("desc"));
                                trace("Retrieving Site ("+s.id+","+s.description+")");
                                sites.add(s);
                        }
                } catch(SQLException e) {
                        System.err.println(e.getMessage());
                }
                return sites;
        }

        @Override
        public List<Station> selectBeacons(int siteID) {
                List<Station> stations = new ArrayList<Station>();
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.
                        ResultSet rs = statement.executeQuery("select * from stations where site_id="+siteID);
                        while(rs.next())
                        {
                                Station s = new Station(rs.getInt("id"),siteID,rs.getString("desc"));
                                stations.add(s);
                        }
                } catch(SQLException e) {
                        System.err.println(e.getMessage());
                }
                return stations;
        }

        @Override
        public List<SensorInfo> selectSensors(int beaconID) {
                List<SensorInfo> infos = new ArrayList<SensorInfo>();
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.
                        ResultSet rs = statement.executeQuery("select * from sites");
                        while(rs.next())
                        {
                                SensorInfo s = new SensorInfo(
                                                rs.getInt("station_id"),
                                                rs.getInt("type"),
                                                rs.getInt("period"),
                                                rs.getFloat("charge"),
                                                rs.getFloat("temp"),
                                                rs.getFloat("rssi"),
                                                rs.getDouble("timestamp"));
                                infos.add(s);
                        }
                } catch(SQLException e) {
                        System.err.println(e.getMessage());
                }
                return infos;
        }

        @Override
        public Site insertSite(String description) {
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.
                        statement.executeUpdate("insert into sites(desc) values('"+description+"')");
                        ResultSet rs = statement.executeQuery("select * from sites where desc='"+description+"'");
                        rs.next();
                        Site s = new Site(rs.getInt("id"),rs.getString("desc"));
                        trace("Adding Site ("+s.id+","+s.description+")");
                        return s;
                } catch(SQLException e) {
                        System.err.println(e.getMessage());
                        return null;
                }
        }

        @Override
        public Station insertBeacon(int siteID, String description) {
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.
                        statement.executeUpdate("insert into stations(desc,site_id) values('"+description+"',"+siteID+")");
                        ResultSet rs = statement.executeQuery("select * from stations where desc='"+description+"' and site_id="+siteID);
                        rs.next();
                        Station s = new Station(rs.getInt("id"),siteID,rs.getString("desc"));
                        return s;
                } catch(SQLException e) {
                        System.err.println(e.getMessage());
                        return null;
                }
        }

        @Override
        public SensorInfo insertSensor(int stationID, int type,int wakeUpPeriod ,float stateOfCharge, float temperature, float RSSI,double timestamp) {
                try {
                        Statement statement = _connection.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.
                        statement.executeUpdate("insert into infos values("+stationID+","+type+","+wakeUpPeriod+","+stateOfCharge+","+temperature+","+RSSI+","+timestamp+")");
                        SensorInfo i = new SensorInfo(stationID,type,wakeUpPeriod,stateOfCharge,temperature,RSSI,timestamp);
                        return i;
                } catch(SQLException e) {
                        System.err.println(e.getMessage());
                        return null;
                }
        }

}
