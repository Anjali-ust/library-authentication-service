package com.code.library_authentication_service.service;

import com.code.library_authentication_service.entity.UserCredentials;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    public String username;
    public String password;

    public CustomUserDetails(UserCredentials userCredentials){
        this.username = userCredentials.getUsername();
        this.password=userCredentials.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
