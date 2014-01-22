package org.polytech.projetjanvier.webservice.data.dao.entities;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by teffaha on 1/20/14.
 *
 */
public class Beacon {
    @XmlElement
    public int id;
    @XmlElement
    public int siteID;
    @XmlElement
    public String description;

    public Beacon(int id,int siteID,String description){
        this.id = id;
        this.siteID = siteID;
        this.description = description;
    }


}
