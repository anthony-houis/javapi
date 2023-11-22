package com.robot.api.java.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Cours {

    @Id
    @GeneratedValue
    private Long id;
    private String salle;

    private String matiere;

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

    public LocalDateTime getDebut() {
        return date_debut;
    }

    public void setDebut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getFin() {
        return date_fin;
    }

    public void setFin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }
}
