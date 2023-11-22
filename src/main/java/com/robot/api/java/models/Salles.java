package com.robot.api.java.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Salles {

    @Id
    private String name;

    private String site;

    public String getSalle() {
        return name;
    }

    public void setSalle(String salle) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
