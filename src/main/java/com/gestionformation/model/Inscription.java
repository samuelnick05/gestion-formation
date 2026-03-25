package com.gestionformation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription")
    private int idInscription;

    @Column(name = "date_inscription")
    private String dateInscription;

    @Column(nullable = false)
    private String statut;

    @Column(length = 500)
    private String appreciation;

    @Column(name = "document")
    private String document;

    public Inscription() {}

    public Inscription(int idInscription, String dateInscription, String statut) {
        this.idInscription = idInscription;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }

    public void valider() {
        this.statut = "Validée";
        System.out.println("Inscription #" + idInscription + " validée.");
    }

    public void annuler() {
        this.statut = "Annulée";
        System.out.println("Inscription #" + idInscription + " annulée.");
    }

    public int getIdInscription() { return idInscription; }
    public void setIdInscription(int idInscription) { this.idInscription = idInscription; }
    public String getDateInscription() { return dateInscription; }
    public void setDateInscription(String dateInscription) { this.dateInscription = dateInscription; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public String getAppreciation() { return appreciation; }
    public void setAppreciation(String appreciation) { this.appreciation = appreciation; }
    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }
}