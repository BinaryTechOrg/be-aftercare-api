package com.aftercare.aftercareapi.Services;

import com.aftercare.aftercareapi.Mappers.PatientMapper;
import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Models.PatientDTO;
import com.aftercare.aftercareapi.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddPatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void addPatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.toEntity(patientDTO);
        patientRepository.save(patient);
    }

    public List<PatientDTO> getPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(int patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
        return PatientMapper.toDTO(patient);
    }

    public void deletePatientById(int patientId) {
        patientRepository.deleteById(patientId);
    }
}
