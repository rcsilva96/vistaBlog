package com.techvista.vistablog.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    String validateJwtToken(String token);
}
