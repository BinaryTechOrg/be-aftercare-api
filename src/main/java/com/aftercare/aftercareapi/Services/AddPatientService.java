package com.aftercare.aftercareapi.Services;

import com.aftercare.aftercareapi.Exceptions.Patients.PatientNotFoundException;
import com.aftercare.aftercareapi.Exceptions.Patients.PatientsListNotFound;
import com.aftercare.aftercareapi.Mappers.PatientMapper;
import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Models.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddPatientService {

    private List<Patient> patientList = new ArrayList<>();
    private int currentID = 0;

    //TODO MAIN FUNCTION THAT CALLS ALL THE OTHERS DEPENDING ON THE CALL OR CLIENT CALL

    //TODO DB CONNECTION CLIENT FOR LISTE
    public List<Patient> getPatients() throws PatientsListNotFound {
        return patientList;
    }

    public Patient getPatientById(int id) throws PatientNotFoundException {
        try {
            return patientList
                    .stream()
                    .filter(patient -> patient.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new PatientNotFoundException("Patient with ID " + id + " not found"));
        } catch (PatientNotFoundException e) {
            // Log the exception and rethrow it
            // You can use a logging framework like SLF4J
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void addPatient(PatientDTO patientDTO) {
        try {
            patientDTO.setId(generateId());
            Patient patient = PatientMapper.INSTANCE.patientDTOToEntity(patientDTO);
            patientList.add(patient);
        } catch (Exception e) {
            // Log the exception and handle it if necessary
            System.err.println("Error adding patient: " + e.getMessage());
            // Rethrow or handle the exception
            throw e;
        }
    }

    public void deletePatientById(int id) throws PatientNotFoundException {
        patientList.removeIf(patient -> patient.getId() == id);
    }

    private synchronized int generateId(){
        return ++currentID;
    }
}
