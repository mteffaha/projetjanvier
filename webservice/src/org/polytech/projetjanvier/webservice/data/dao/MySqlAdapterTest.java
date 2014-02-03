package org.polytech.projetjanvier.webservice.data.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.polytech.projetjanvier.webservice.data.dao.entities.SensorInfo;
import org.polytech.projetjanvier.webservice.data.dao.entities.Site;
import org.polytech.projetjanvier.webservice.data.dao.entities.Station;

public class MySqlAdapterTest {
        
        private static MySqlAdapter adapter = new MySqlAdapter();
        
        @BeforeClass
        public static void connect() {
                adapter.openConnection("private/webservice/test.db");
        }
        
        @Before
        public void clearDB() {
                adapter.initDB();
        }
        
        @AfterClass
        public static void disconnect() {
                adapter.closeConnection();
        }
        /*
        @Test
        public void dbIsCleared() {
                assertEquals(0,adapter.selectSites().size());
        }
        */
        @Test
        public void siteTest() {
                Site si = adapter.insertSite("Nice");
                adapter.insertSite("Paris");
                assertTrue(si.description.equals("Nice"));
                List<Site> sites = adapter.selectSites();
                assertEquals(2,sites.size());
                Site p = sites.get(1);
                assertTrue(p.description.equals("Paris") || p.id!=2);
                Station st = adapter.insertBeacon(1, "Station de Nice");
                assertTrue(st.description.equals("Station de Nice"));
                SensorInfo sf = adapter.insertSensor(1, 1, 5, 0.65f, 34.0f, 0.3f, 123.4);
                assertTrue(sf.temperature==34.0f);
        }

}
