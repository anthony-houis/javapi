package com.robot.api.java.repository;

import com.robot.api.java.models.Cours;
import com.robot.api.java.models.Salles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface SallesRepository extends JpaRepository<Salles, Long> {
    //List<Salles> findSallesNotInCoursWhereDateDebutThanEqual(LocalDateTime dateDebut);
}
