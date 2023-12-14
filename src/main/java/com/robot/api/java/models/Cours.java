package com.robot.api.java.models;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cours {

    @Id
    @GeneratedValue
    private Long id;
    public String salle;

    public String matiere;

    private String section;

    private String groupe;

    private LocalDateTime date_debut;

    private LocalDateTime date_fin;

    private String professeur;

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public LocalDateTime getDateDebut() {
        return date_debut;
    }

    public void setDateDebut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDateFin() {
        return date_fin;
    }

    public void setDateFin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }
}
