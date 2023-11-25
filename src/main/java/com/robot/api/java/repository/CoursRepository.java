package com.robot.api.java.repository;

import com.robot.api.java.models.Cours;
import com.robot.api.java.models.Salles;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findBySalle(String salle);
    List<Cours> findByGroupeAndSectionAndDateDebutGreaterThanEqual(String groupe, String section, LocalDateTime dateDebut);
    List<Cours> findAllCoursByGroupeAndDateDebutGreaterThanEqual(String groupe, LocalDateTime dateDebut);
    List<Cours> findAllCoursBySectionAndDateDebutGreaterThanEqual(String section, LocalDateTime dateDebut);
    List<Cours> findAllCoursByProfesseurAndDateDebutGreaterThanEqual(String name, LocalDateTime dateDebut);
    List<Cours> findCoursSallesByDateDebut(LocalDateTime dateDebut);
}
