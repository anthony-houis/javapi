package com.robot.api.java.controllers;

import com.robot.api.java.dto.AddCoursRequest;
import com.robot.api.java.exceptions.NullOrEmptyException;
import com.robot.api.java.models.Cours;
import com.robot.api.java.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    @GetMapping("/getCours/{groupe}/{section}/{date_debut}")
    public ResponseEntity<List<Cours>> getCours(@PathVariable final String groupe,
                                                @PathVariable final String section,
                                                @PathVariable final LocalDateTime date_debut
    ) {
        final List<Cours> list = coursRepository.findByGroupeAndSectionAndDate(groupe, section, date_debut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCoursByGroupe")
    public ResponseEntity<List<Cours>> getCoursByGroupe(@RequestParam final String groupe,
                                                        @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date_debut) {

        final List<Cours> list = coursRepository.findAllCoursByGroupeAndDate(groupe, date_debut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCoursBySection")
    public ResponseEntity<List<Cours>> getCoursBySection(@RequestParam final String section,
                                                        @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date_debut) {

        final List<Cours> list = coursRepository.findAllCoursBySectionAndDate(section, date_debut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getCoursByProfesseurs")
    public ResponseEntity<List<Cours>> getCoursByProfesseurs(@RequestParam final String name,
                                                         @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date_debut) {

        final List<Cours> list = coursRepository.findAllCoursByProfesseurAndDate(name, date_debut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getSalles")
    public ResponseEntity<List<Cours>> getSalles(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date_debut) {
        final List<Cours> list = coursRepository.findCoursSallesByDate(date_debut);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/infoTitre")
    public ResponseEntity<String> infoTitre() throws IOException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("python3 " + "/home/javapi/rss.py");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        String line = null;
        String results = null;
        while ((line = in .readLine()) != null) {
            results = line;
        }

        return ResponseEntity.ok(results);
    }

    @GetMapping("/infoDetails")
    public ResponseEntity<String> infoDetails() throws IOException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec("python3 " + "/home/javapi/rssDetails.py");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        String line = null;
        String results = null;
        while ((line = in .readLine()) != null) {
            results = line;
        }

        return ResponseEntity.ok(results);
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
