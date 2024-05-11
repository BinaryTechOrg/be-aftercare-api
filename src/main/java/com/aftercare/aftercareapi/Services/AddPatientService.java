package com.aftercare.aftercareapi.Services;

import com.aftercare.aftercareapi.Models.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddPatientService {

    public List<Patient> getPatients() {
        List <Patient> patients = new ArrayList<>();
        Patient patient1 = new Patient();
        patient1.setFirstName("Jan");
        patient1.setLastName("Doe");
        patient1.setId(2);
        patients.add(patient1);
        Patient patient2 = new Patient();
        patients.add(patient2);
        return patients;
    }

    public Patient getPatientById(int id) {
        List<Patient> patientList = getPatients();

        return patientList
                .stream()
                .filter(patient -> patient.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Patient addPatient(Patient patient) {
        List<Patient> patientList = getPatients();
        patientList.add(patient);

        return patient;
    }
}
