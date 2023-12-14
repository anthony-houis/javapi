package com.robot.api.java.repository;

import com.robot.api.java.models.Cours;
import com.robot.api.java.models.Professeurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesseursRepository extends JpaRepository<Professeurs, Long> {

    @Query(value="select contact from professeurs where name= :name",nativeQuery=true)
    String findContactByName(@Param(value="name") String name);
    @Query(value="select professeurs.contact from professeurs, cours where professeurs.name = cours.professeur and cours.matiere = :matiere",nativeQuery=true)
    String findOneProfesseurByCoursMatiere(@Param(value="matiere") String matiere);
}
