package com.aftercare.aftercareapi.Mappers;

import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Models.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO patientToDTO(Patient patient);

    Patient patientDTOToEntity(PatientDTO patientDTO);
}
