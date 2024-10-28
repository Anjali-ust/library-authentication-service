package com.code.library_authentication_service.service;

import com.code.library_authentication_service.entity.UserCredentials;
import com.code.library_authentication_service.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    private UserCredentialsRepo userrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserCredentials registerUser(UserCredentials user) {
              user.setPassword(passwordEncoder.encode(user.getPassword()));
              return userrepo.save(user);
    }

    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
}
