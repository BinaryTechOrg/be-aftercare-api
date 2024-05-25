package com.aftercare.aftercareapi.Exceptions.Patients;

public class PatientsListNotFound extends RuntimeException{
    public PatientsListNotFound(String message) {
        super(message);
    }
}
