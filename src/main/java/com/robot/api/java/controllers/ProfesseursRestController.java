package com.robot.api.java.controllers;

import com.robot.api.java.models.Professeurs;
import com.robot.api.java.repository.ProfesseursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseursRestController {
    @Autowired
    private ProfesseursRepository professeursRepository;

    @GetMapping("/getByName/{name}")
    public ResponseEntity<String> getContactByName(@PathVariable String name) {
        String contact = professeursRepository.findContactByName(name);
        return ResponseEntity.ok(contact);
    }
    @GetMapping("/getByCours/{matiere}")

    public ResponseEntity<String> getContactByCours(@PathVariable String matiere) {

        try {
            // Ajoutez des logs ici
            System.out.println("Requête getByCours avec matiere :"+ matiere);

            String prof = professeursRepository.findOneProfesseurByCoursMatiere(matiere);

            // Ajoutez des logs pour vérifier le résultat
            System.out.println("Résultat de la requête :"+ prof);

            return ResponseEntity.ok(prof);
        } catch (Exception e) {
            // Ajoutez un log pour l'exception
            System.out.println("Erreur lors du traitement de la requête getByCours"+ e);
            throw e; // Ne pas oublier de gérer correctement les exceptions dans votre application
        }
        //prof = professeursRepository.findOneProfesseurByCoursMatiere(matiere);
        //return ResponseEntity.ok(prof);
    }
}
