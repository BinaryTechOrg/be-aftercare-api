package com.aftercare.aftercareapi.Exceptions.Patients;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
