package com.gestionformation;

import com.gestionformation.model.*;
import com.gestionformation.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Ce fichier s'exécute automatiquement au démarrage de Spring Boot.
 * Il insère les données initiales UNIQUEMENT si la base est vide.
 * Grâce à la condition "if (formationRepo.count() == 0)",
 * les données ne sont jamais dupliquées si tu redémarres l'application.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final FormationRepository formationRepo;
    private final SessionRepository sessionRepo;
    private final OrganismeFormationRepository organismeRepo;

    public DataInitializer(
            FormationRepository formationRepo,
            SessionRepository sessionRepo,
            OrganismeFormationRepository organismeRepo) {
        this.formationRepo  = formationRepo;
        this.sessionRepo    = sessionRepo;
        this.organismeRepo  = organismeRepo;
    }

    @Override
    public void run(String... args) {

        // ── N'insère que si le catalogue est vide ──
        if (formationRepo.count() == 0) {

            System.out.println(">>> Initialisation des données de départ...");

            // ── Organismes de formation ──
            OrganismeFormation ufhb = new OrganismeFormation(
                    1, "UFHB", "Abidjan Cocody"
            );
            OrganismeFormation cfci = new OrganismeFormation(
                    2, "CFCI - Centre de Formation Continue", "Abidjan Plateau"
            );
            OrganismeFormation ina = new OrganismeFormation(
                    3, "INA - Institut National des Arts", "Abidjan Treichville"
            );
            organismeRepo.save(ufhb);
            organismeRepo.save(cfci);
            organismeRepo.save(ina);

            // ── Formations ──
            Formation f1 = new Formation(
                    1,
                    "Développement Java & Spring Boot",
                    "Maîtrise des fondamentaux Java, programmation orientée objet, " +
                            "développement d'APIs REST avec Spring Boot et gestion de bases de données avec JPA/Hibernate."
            );

            Formation f2 = new Formation(
                    2,
                    "Gestion de Projet Agile & Scrum",
                    "Introduction aux méthodologies agiles, rôles Scrum (Product Owner, Scrum Master), " +
                            "organisation des sprints, rétrospectives et outils de suivi de projet."
            );

            Formation f3 = new Formation(
                    3,
                    "Sécurité Informatique & Cybersécurité",
                    "Identification des menaces et vulnérabilités, bonnes pratiques de sécurité, " +
                            "gestion des accès, chiffrement des données et sensibilisation aux attaques courantes."
            );

            Formation f4 = new Formation(
                    4,
                    "Communication Professionnelle & Prise de Parole",
                    "Techniques de communication orale et écrite en milieu professionnel, " +
                            "prise de parole en public, rédaction de rapports et conduite de réunions efficaces."
            );

            Formation f5 = new Formation(
                    5,
                    "Analyse de Données & Excel Avancé",
                    "Exploitation avancée d'Excel : tableaux croisés dynamiques, formules complexes, " +
                            "macros VBA, visualisation de données et initiation à Power BI."
            );

            Formation f6 = new Formation(
                    6,
                    "Management & Leadership",
                    "Développement des compétences managériales : motivation des équipes, " +
                            "gestion des conflits, délégation, feedback constructif et styles de leadership."
            );

            formationRepo.save(f1);
            formationRepo.save(f2);
            formationRepo.save(f3);
            formationRepo.save(f4);
            formationRepo.save(f5);
            formationRepo.save(f6);

            // ── Sessions initiales ──
            Session s1 = new Session(1, "2025-09-10", 150000f);
            Session s2 = new Session(2, "2025-09-25", 120000f);
            Session s3 = new Session(3, "2025-10-08", 180000f);
            Session s4 = new Session(4, "2025-10-20", 95000f);
            Session s5 = new Session(5, "2025-11-05", 200000f);

            sessionRepo.save(s1);
            sessionRepo.save(s2);
            sessionRepo.save(s3);
            sessionRepo.save(s4);
            sessionRepo.save(s5);

            System.out.println(">>> ✅ 6 formations et 5 sessions chargées avec succès !");

        } else {
            System.out.println(">>> Base de données déjà initialisée — aucune insertion.");
        }
    }
}