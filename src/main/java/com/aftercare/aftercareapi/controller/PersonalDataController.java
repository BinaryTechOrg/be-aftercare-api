package com.aftercare.aftercareapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalDataController {

    @GetMapping(value = "api/data")
    public ResponseEntity<String> data() {

        return ResponseEntity.ok("Hello World");
    }

    @PostMapping(value = "api/data/checkups")
    public ResponseEntity<String> checkups() {
        return ResponseEntity.ok("Hello World");
    }
}
