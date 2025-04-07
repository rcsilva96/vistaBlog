package com.techvista.vistablog.services;

import com.techvista.vistablog.request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

    String getToken(AuthRequest auth);

    String validateJwtToken(String token);
}
