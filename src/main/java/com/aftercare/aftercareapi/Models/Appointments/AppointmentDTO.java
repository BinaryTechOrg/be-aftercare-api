package com.aftercare.aftercareapi.Models.Appointments;

import lombok.Data;

@Data
public class AppointmentDTO {
    private int appointmentId;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentStatus;
}
