package com.robot.api.java.controllers;

import com.robot.api.java.models.Salles;
import com.robot.api.java.repository.SallesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/salles")
public class SallesRestController {

    @Autowired
    private SallesRepository sallesRepository;

    /*@GetMapping("/getSallesNotInCours")
    public ResponseEntity<List<Salles>> getSallesNotInCours(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime dateDebut) {
        final List<Salles> list = sallesRepository.findSallesNotInCoursWhereDateDebutThanEqual(dateDebut);
        return ResponseEntity.ok(list);
    }*/
}
