package com.aftercare.aftercareapi.Models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private Address address;

    //TODO Move to utilityClass
    public void convertGender(String gender){
        if(gender.equalsIgnoreCase("m")){
            this.gender = "male";
        }

        if(gender.equalsIgnoreCase("f")){
            this.gender = "female";
        }
    }
}
