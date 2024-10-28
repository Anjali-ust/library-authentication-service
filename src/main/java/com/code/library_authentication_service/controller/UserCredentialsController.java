package com.code.library_authentication_service.controller;

import com.code.library_authentication_service.entity.UserCredentials;
import com.code.library_authentication_service.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/authentication")
public class UserCredentialsController {
    @Autowired
    private UserCredentialsService userService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/register")
    public UserCredentials registerUser(@RequestBody UserCredentials user){
        return userService.registerUser(user);
    }

    @GetMapping("/validatetoken")
    public boolean verifyToken(@RequestParam("token") String token){
        return userService.verifyToken(token);
    }

    @PostMapping("/validateuser")
    public String getToken(@RequestBody UserCredentials user)
    {
        Authentication authenticate = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authenticate.isAuthenticated()){
            return userService.generateToken(user.getUsername());
        }
        return "Invalid credentials";
    }


}
