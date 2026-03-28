package com.gestionformation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employe {

    @Id
    @Column(name = "numero_employe")
    private int numeroEmploye;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    public Employe() {}

    public Employe(int numeroEmploye, String nom, String adresse) {
        this.numeroEmploye = numeroEmploye;
        this.nom = nom;
        this.adresse = adresse;
    }

    public void afficher() {
        System.out.println("Employé #" + numeroEmploye + " | Nom: " + nom + " | Adresse: " + adresse);
    }

    public int getNumeroEmploye() { return numeroEmploye; }
    public void setNumeroEmploye(int numeroEmploye) { this.numeroEmploye = numeroEmploye; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}