package com.gestionformation.repository;
import com.gestionformation.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {}