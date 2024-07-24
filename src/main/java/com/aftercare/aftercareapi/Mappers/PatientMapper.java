package com.aftercare.aftercareapi.Mappers;

import com.aftercare.aftercareapi.Models.AddressDTO;
import com.aftercare.aftercareapi.Models.Patient;
import com.aftercare.aftercareapi.Models.Address;
import com.aftercare.aftercareapi.Models.PatientDTO;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {
        if (patient == null) {
            return null;
        }

        return PatientDTO.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .password(patient.getPassword())
                .phone(patient.getPhone())
                .gender(patient.getGender())
                .address(toAddressDTO(patient.getAddress()))
                .build();
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }

        return Patient.builder()
                .id(patientDTO.getId())
                .firstName(patientDTO.getFirstName())
                .lastName(patientDTO.getLastName())
                .email(patientDTO.getEmail())
                .password(patientDTO.getPassword())
                .phone(patientDTO.getPhone())
                .gender(patientDTO.getGender())
                .address(toAddress(patientDTO.getAddress()))
                .build();
    }

    private static AddressDTO toAddressDTO(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDTO.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .postalCode(address.getPostalCode())
                .build();
    }

    private static Address toAddress(AddressDTO addressDTO) {
        if (addressDTO == null) {
            return null;
        }

        return Address.builder()
                .street(addressDTO.getStreet())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .postalCode(addressDTO.getPostalCode())
                .build();
    }
}
