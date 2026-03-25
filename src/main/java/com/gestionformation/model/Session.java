package com.gestionformation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @Column(name = "id_session")
    private int idSession;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private float prix;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private List<Inscription> inscriptions = new ArrayList<>();

    public Session() {}

    public Session(int idSession, String date, float prix) {
        this.idSession = idSession;
        this.date = date;
        this.prix = prix;
    }

    public void afficher() {
        System.out.println("Session #" + idSession + " | " + date + " | " + prix + " FCFA");
    }

    public void ajouterInscription(Inscription inscription) { inscriptions.add(inscription); }

    public int getIdSession() { return idSession; }
    public void setIdSession(int idSession) { this.idSession = idSession; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public float getPrix() { return prix; }
    public void setPrix(float prix) { this.prix = prix; }
    public List<Inscription> getInscriptions() { return inscriptions; }
}