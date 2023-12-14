package com.robot.api.java.controllers;

import com.robot.api.java.models.Salles;
import com.robot.api.java.repository.SallesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/salles")
public class SallesRestController {

    @Autowired
    private SallesRepository sallesRepository;

    @GetMapping("/getBySite/{site}")
    public ResponseEntity<List<String>> getSallesBySite(@PathVariable String site) {
        List<String> salles = sallesRepository.findAllSallesBySite(site);
        return ResponseEntity.ok(salles);
    }

    @GetMapping("/getSiteBySalle/{salle}")
    public ResponseEntity<String> getSiteBySalle(@PathVariable String salle) {
        String site = sallesRepository.findSiteBySalle(salle);
        return ResponseEntity.ok(site);
    }

    @GetMapping("/getFreeSallesPM/{date}")
    public ResponseEntity<List<String>> getFreeSallesPM(@PathVariable String date) {
        LocalDateTime reqdate = LocalDateTime.parse(date+"T13:00:00");
        List<String> salles = sallesRepository.findFreeSallesPM(reqdate);
        return ResponseEntity.ok(salles);
    }

    @GetMapping("/getFreeSallesAM/{date}")
    public ResponseEntity<List<String>> getFreeSallesAM(@PathVariable String date) {
        LocalDateTime reqdate = LocalDateTime.parse(date+"T13:00:00");
        List<String> salles = sallesRepository.findFreeSallesAM(reqdate);
        return ResponseEntity.ok(salles);
    }

    @GetMapping("/getFreeSalles/{heure}")
    public ResponseEntity<List<String>> getFreeSalles(@PathVariable String heure) {
        LocalDateTime reqdate = LocalDateTime.parse("2023-11-16T"+heure);
        List<String> salles = sallesRepository.findFreeSallesAM(reqdate);
        return ResponseEntity.ok(salles);
    }

    @GetMapping("/getFreeSalles")
    public ResponseEntity<List<String>> getFreeSallesAM() {
        List<String> salles = sallesRepository.findFreeSalles();
        return ResponseEntity.ok(salles);
    }

    @GetMapping("/getFreeSallesDate/{date}")
    public ResponseEntity<List<String>> getFreeSallesAM(@PathVariable LocalDateTime date) {
        List<String> salles = sallesRepository.findFreeSallesDate(date);
        return ResponseEntity.ok(salles);
    }
}
