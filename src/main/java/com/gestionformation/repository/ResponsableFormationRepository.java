package com.gestionformation.repository;
import com.gestionformation.model.ResponsableFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ResponsableFormationRepository extends JpaRepository<ResponsableFormation, Integer> {}