package com.robot.api.java.repository;

import com.robot.api.java.models.Cours;
import com.robot.api.java.models.Salles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface SallesRepository extends JpaRepository<Salles, Long> {
    @Query(value="select name from salles where site = :site", nativeQuery = true)
    List<String> findAllSallesBySite(@Param(value="site") String site);

    @Query(value="select site from salles where name = :salle", nativeQuery = true)
    String findSiteBySalle(@Param(value="salle") String salle);

    @Query(value="select distinct salle from cours where date_fin<= :date union select name from salles where name not in (select salle from cours)", nativeQuery = true)
    List<String> findFreeSallesPM(@Param(value="date") LocalDateTime date);

    @Query(value="select distinct salle from cours where date_debut>= :date union select name from salles where name not in (select salle from cours)", nativeQuery = true)
    List<String> findFreeSallesAM(@Param(value="date") LocalDateTime date);

    @Query(value="select name from salles where name not in (select salle from cours)", nativeQuery = true)
    List<String> findFreeSalles();

    @Query(value="select salle from cours where date_fin>= :date and date_debut<= :date", nativeQuery = true)
    List<String> findFreeSallesDate(@Param(value="date") LocalDateTime date);
}
