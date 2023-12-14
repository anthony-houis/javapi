package com.robot.api.java.repository;

import com.robot.api.java.models.Cours;
import com.robot.api.java.models.Salles;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findBySalle(String salle);
    @Query(value="select * from cours where groupe= :groupe and section = :section and date_debut>= :date_debut", nativeQuery = true)
    List<Cours> findByGroupeAndSectionAndDate(@Param(value="groupe") String groupe, @Param(value="section") String section, @Param(value="date_debut") LocalDateTime date_debut);
    @Query(value="select * from cours where groupe= :groupe and date_debut>= :date_debut", nativeQuery = true)
    List<Cours> findAllCoursByGroupeAndDate(@Param(value="groupe") String groupe, @Param(value="date_debut") LocalDateTime date_debut);
    @Query(value="select * from cours where section = :section and date_debut>= :date_debut", nativeQuery = true)
    List<Cours> findAllCoursBySectionAndDate(@Param(value="section") String section, @Param(value="date_debut") LocalDateTime date_debut);
    @Query(value="select * from cours where professeur= :name and date_debut>= :date_debut", nativeQuery = true)
    List<Cours> findAllCoursByProfesseurAndDate(@Param(value="name") String name, @Param(value="date_debut") LocalDateTime date_debut);
    @Query(value="select cours, salle from cours where date_debut>= :date_debut", nativeQuery = true)
    List<Cours> findCoursSallesByDate(@Param(value="date_debut") LocalDateTime date_debut);
}
