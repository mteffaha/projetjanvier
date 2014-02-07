package org.polytech.projetjanvier.android.entities;

/**
 * Created by teffaha on 2/3/14.
 */
public class Site {

    private int id;
    private String title;
    private String description;
    private int nbCapteurs;

    public Site(int id,String title,String description,int nbCapteurs){
        this.id = id;
        this.title = title;
        this.description = description;
        this.nbCapteurs = nbCapteurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbCapteurs() {
        return nbCapteurs;
    }

    public void setNbCapteurs(int nbCapteurs) {
        this.nbCapteurs = nbCapteurs;
    }
}
