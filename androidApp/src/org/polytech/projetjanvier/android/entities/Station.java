package org.polytech.projetjanvier.android.entities;

/**
 * Created by teffaha on 1/28/14.
 */
public class Station {

    private int id;
    private int siteID;
    public Station(int id,int siteID){
        this.id = id;
        this.siteID = siteID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }
}
