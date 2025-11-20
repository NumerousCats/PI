package com.example.authentication.controller;

import com.example.authentication.dto.CreateAccountRequest;
import com.example.authentication.entities.AppUser;
import com.example.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/createAccount")
    public AppUser createAccount(@RequestBody CreateAccountRequest request) {
        return authenticationService.createAccount(request);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");

        boolean success = authenticationService.authenticate(email, password);
        return success ? "success" : "failure";
    }
}
