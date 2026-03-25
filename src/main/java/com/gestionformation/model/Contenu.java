package com.gestionformation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contenus")
public class Contenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_contenu")
    private int numeroContenu;

    @Column(nullable = false)
    private String description;

    public Contenu() {}

    public Contenu(int numeroContenu, String description) {
        this.numeroContenu = numeroContenu;
        this.description = description;
    }

    public void afficher() {
        System.out.println("Contenu #" + numeroContenu + " : " + description);
    }

    public int getNumeroContenu() { return numeroContenu; }
    public void setNumeroContenu(int numeroContenu) { this.numeroContenu = numeroContenu; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}