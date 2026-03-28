package com.gestionformation.repository;
import com.gestionformation.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {}