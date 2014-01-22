package org.polytech.projetjanvier.webservice.data.dao.entities;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by teffaha on 1/20/14.
 */
public class Site {
    @XmlElement
    public int id;
    @XmlElement
    public String description;


    public Site(int id,String description){
        this.id= id;
        this.description = description;
    }


}
