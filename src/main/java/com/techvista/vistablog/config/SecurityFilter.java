package com.techvista.vistablog.config;

import com.techvista.vistablog.models.UserModel;
import com.techvista.vistablog.repositories.UserRepository;
import com.techvista.vistablog.services.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {

        String token = extractToken(request);

        if (token != null) {

            String username = authenticationService.validateJwtToken(token);
            UserModel user = userRepository.findByUserName(username);

            var authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

        filterChain.doFilter(request, response);

    }

    private String extractToken(HttpServletRequest request) {

        var authHeader = request.getHeader("Authorization");

        if (authHeader == null){
            return null;
        }

        if (!authHeader.split(" ")[0].equals("Bearer")){

            return null;

        }

        return authHeader.split(" ")[1];

    }

}
