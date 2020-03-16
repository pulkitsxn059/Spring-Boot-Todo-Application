package com.example.springbootfirstapplication.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validate(String userId, String password)
    {
        return userId.equalsIgnoreCase("pulkit") && password.equalsIgnoreCase("pulkit123");
    }
}
