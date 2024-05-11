package com.aftercare.aftercareapi.Models.Appointments;

import lombok.Data;

@Data
public class AppointmentResponse {
    private int appointmentId;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentStatus;
    private String appointmentLocation;
    private String appointmentType;
}
