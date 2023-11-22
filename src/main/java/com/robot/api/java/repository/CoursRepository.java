package com.robot.api.java.repository;

import com.robot.api.java.models.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findBySalle(String salle);
}
