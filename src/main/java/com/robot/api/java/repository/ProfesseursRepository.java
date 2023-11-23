package com.robot.api.java.repository;

import com.robot.api.java.models.Professeurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesseursRepository extends JpaRepository<Professeurs, Long> {

    List<Professeurs> findContactByName(String name);
}
