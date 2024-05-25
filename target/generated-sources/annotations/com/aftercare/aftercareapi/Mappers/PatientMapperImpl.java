package com.aftercare.aftercareapi.Mappers;

import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Models.PatientDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-25T17:44:22-0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDTO patientToDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO.PatientDTOBuilder patientDTO = PatientDTO.builder();

        patientDTO.id( patient.getId() );
        patientDTO.firstName( patient.getFirstName() );
        patientDTO.lastName( patient.getLastName() );
        patientDTO.email( patient.getEmail() );
        patientDTO.phone( patient.getPhone() );
        patientDTO.gender( patient.getGender() );
        patientDTO.address( patient.getAddress() );

        return patientDTO.build();
    }

    @Override
    public Patient patientDTOToEntity(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient.PatientBuilder patient = Patient.builder();

        patient.id( patientDTO.getId() );
        patient.firstName( patientDTO.getFirstName() );
        patient.lastName( patientDTO.getLastName() );
        patient.email( patientDTO.getEmail() );
        patient.phone( patientDTO.getPhone() );
        patient.gender( patientDTO.getGender() );
        patient.address( patientDTO.getAddress() );

        return patient.build();
    }
}
