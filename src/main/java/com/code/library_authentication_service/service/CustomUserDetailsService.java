package com.code.library_authentication_service.service;

import com.code.library_authentication_service.entity.UserCredentials;
import com.code.library_authentication_service.repo.UserCredentialsRepo;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialsRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> user = userRepo.findByUsername(username);
        return user.map(CustomUserDetails::new)
                .orElseThrow(() ->  new UsernameNotFoundException("User "+username+" is not found"));
    }
}
