package com.aftercare.aftercareapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    @GetMapping(value = "api/rooms")
    public ResponseEntity<String> hospitals() {

        return ResponseEntity.ok("Hospital rooms");
    }
}
