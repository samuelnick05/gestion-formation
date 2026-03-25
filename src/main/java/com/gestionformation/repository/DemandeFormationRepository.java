package com.gestionformation.repository;
import com.gestionformation.model.DemandeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DemandeFormationRepository extends JpaRepository<DemandeFormation, Integer> {}