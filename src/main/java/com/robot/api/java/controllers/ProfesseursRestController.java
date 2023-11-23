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
    public ResponseEntity<List<Professeurs>> getContactByName(@PathVariable() final String name) {
        final List<Professeurs> contact = professeursRepository.findContactByName(name);
        return ResponseEntity.ok(contact);
    }
}
