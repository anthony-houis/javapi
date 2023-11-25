package com.robot.api.java.controllers;

import com.robot.api.java.dto.AddCoursRequest;
import com.robot.api.java.exceptions.NullOrEmptyException;
import com.robot.api.java.models.Cours;
import com.robot.api.java.models.Salles;
import com.robot.api.java.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursRestController {

    @Autowired
    private CoursRepository coursRepository;

    @GetMapping("/getAllCours")
    public ResponseEntity<List<Cours>> getAllCours() {
        final List<Cours> list = coursRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getBySalle/{salle}")
    public ResponseEntity<List<Cours>> getBySalle(@PathVariable() final String salle) {
        final List<Cours> list = coursRepository.findBySalle(salle);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCours")
    public ResponseEntity<List<Cours>> getCours(@RequestParam final String groupe,
                                                @RequestParam final String section,
                                                @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime dateDebut
    ) {
        final List<Cours> list = coursRepository.findByGroupeAndSectionAndDateDebutGreaterThanEqual(groupe, section, dateDebut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCoursByGroupe")
    public ResponseEntity<List<Cours>> getCoursByGroupe(@RequestParam final String groupe,
                                                        @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime dateDebut) {

        final List<Cours> list = coursRepository.findAllCoursByGroupeAndDateDebutGreaterThanEqual(groupe, dateDebut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCoursBySection")
    public ResponseEntity<List<Cours>> getCoursBySection(@RequestParam final String section,
                                                        @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime dateDebut) {

        final List<Cours> list = coursRepository.findAllCoursBySectionAndDateDebutGreaterThanEqual(section, dateDebut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCoursByProfesseurs")
    public ResponseEntity<List<Cours>> getCoursByProfesseurs(@RequestParam final String name,
                                                         @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime dateDebut) {

        final List<Cours> list = coursRepository.findAllCoursByProfesseurAndDateDebutGreaterThanEqual(name, dateDebut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getSalles")
    public ResponseEntity<List<Cours>> getSalles(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime dateDebut) {
        final List<Cours> list = coursRepository.findCoursSallesByDateDebut(dateDebut);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/")
    public ResponseEntity<String> addAllCours(@RequestBody AddCoursRequest addCoursRequest) {
        try {
            checkRequiredField(addCoursRequest);
        } catch (NullOrEmptyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        Cours c = new Cours();
        c.setProfesseur(addCoursRequest.getProfesseur());
        c.setDateDebut(addCoursRequest.getDateDebut());
        c.setDateFin(addCoursRequest.getDateFin());
        c.setSection(addCoursRequest.getSection());
        c.setGroupe(addCoursRequest.getGroupe());
        c.setMatiere(addCoursRequest.getMatiere());
        c.setSalle(addCoursRequest.getSalle());

        coursRepository.save(c);

        return ResponseEntity.ok("Cours ajouté");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable() Long id) {
        coursRepository.deleteById(id);
        return ResponseEntity.ok("Cours supprimé");
    }

    private void checkRequiredField(AddCoursRequest addCoursRequest) throws NullOrEmptyException {
        if(!StringUtils.hasText(addCoursRequest.getMatiere())){
            throw new NullOrEmptyException("MatiereName ne peut être null ou vide");
        }

        if(!StringUtils.hasText(addCoursRequest.getSalle())){
            throw new NullOrEmptyException("RoomNme ne peut être null ou vide");
        }

        if(addCoursRequest.getDateDebut() == null){
            throw new NullOrEmptyException("Debut ne peut être null ou vide");
        }

        if(addCoursRequest.getDateFin() == null){
            throw new NullOrEmptyException("Fin ne peut être null ou vide");
        }
    }


}
