package com.gestionformation.repository;
import com.gestionformation.model.OrganismeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrganismeFormationRepository extends JpaRepository<OrganismeFormation, Integer> {}