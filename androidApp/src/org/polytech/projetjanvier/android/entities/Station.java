package org.polytech.projetjanvier.android.entities;

/**
 * Created by teffaha on 1/28/14.
 */
public class Station {

    private int id;
    private int siteID;
    private String title;
    public Station(int id,String title,int siteID){
        this.id = id;
        this.siteID = siteID;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
