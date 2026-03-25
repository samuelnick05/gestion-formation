package com.gestionformation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "responsables_formation")
public class ResponsableFormation extends Employe {

    @Column(name = "date_nomination")
    private String dateNomination;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "responsable_id")
    private List<DemandeFormation> demandes = new ArrayList<>();

    public ResponsableFormation() { super(); }

    public ResponsableFormation(int numeroEmploye, String nom, String adresse, String dateNomination) {
        super(numeroEmploye, nom, adresse);
        this.dateNomination = dateNomination;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Responsable de formation | Nommé le: " + dateNomination);
    }

    public void ajouterDemande(DemandeFormation demande) { demandes.add(demande); }

    public String getDateNomination() { return dateNomination; }
    public void setDateNomination(String dateNomination) { this.dateNomination = dateNomination; }
    public List<DemandeFormation> getDemandes() { return demandes; }
}