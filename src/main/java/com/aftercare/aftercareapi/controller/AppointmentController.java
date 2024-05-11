package com.aftercare.aftercareapi.controller;

import com.aftercare.aftercareapi.Models.Appointments.AppointmentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {

    @GetMapping(value = "/api/appointments")
    public ResponseEntity<List<AppointmentDTO>> appointments(
            @RequestBody AppointmentDTO appointmentDTO
            ) {

        return new ResponseEntity<List<AppointmentDTO>>(HttpStatus.OK);
    }
}
