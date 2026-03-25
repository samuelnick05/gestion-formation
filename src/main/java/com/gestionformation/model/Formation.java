package com.gestionformation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    @Column(name = "numero_formation")
    private int numeroFormation;

    @Column(name = "nom_formation", nullable = false)
    private String nomFormation;

    @Column(name = "contenu_texte", length = 1000)
    private String contenuTexte;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formation_id")
    private List<Contenu> contenus = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "formation_organisme",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "organisme_id")
    )
    private List<OrganismeFormation> organismes = new ArrayList<>();

    public Formation() {}

    public Formation(int numeroFormation, String nomFormation, String contenuTexte) {
        this.numeroFormation = numeroFormation;
        this.nomFormation = nomFormation;
        this.contenuTexte = contenuTexte;
    }

    public void afficher() {
        System.out.println("Formation #" + numeroFormation + " | " + nomFormation);
    }

    public void ajouterContenu(Contenu contenu) { contenus.add(contenu); }
    public void ajouterOrganisme(OrganismeFormation organisme) { organismes.add(organisme); }

    public int getNumeroFormation() { return numeroFormation; }
    public void setNumeroFormation(int numeroFormation) { this.numeroFormation = numeroFormation; }
    public String getNomFormation() { return nomFormation; }
    public void setNomFormation(String nomFormation) { this.nomFormation = nomFormation; }
    public String getContenuTexte() { return contenuTexte; }
    public void setContenuTexte(String contenuTexte) { this.contenuTexte = contenuTexte; }
    public List<Contenu> getContenus() { return contenus; }
    public List<OrganismeFormation> getOrganismes() { return organismes; }
}