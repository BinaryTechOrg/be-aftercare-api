package com.aftercare.aftercareapi.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        return true;
    }

    private void connectDatabase(){

    }

    private void convertPassword(String password){

    }
}
