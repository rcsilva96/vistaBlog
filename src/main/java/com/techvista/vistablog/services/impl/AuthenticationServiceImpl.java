package com.techvista.vistablog.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.techvista.vistablog.models.UserModel;
import com.techvista.vistablog.repositories.UserRepository;
import com.techvista.vistablog.request.AuthRequest;
import com.techvista.vistablog.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        return userRepository.findByUsername(login);
    }

    @Override
    public String getToken(AuthRequest auth){
        UserModel user = userRepository.findByUsername(auth.getUsername());
        return generateToken(user);
    }

    private String generateToken(UserModel user) {

        try {

            Algorithm algorithm = Algorithm.HMAC256("my-secret");

            return JWT.create()
                    .withIssuer("vistaBlog")
                    .withSubject("user.getUsername()")
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {

            throw new RuntimeException("Falha ao gerar token " + exception.getMessage());

        }

        }


    public String validateJwtToken(String token){

        try {

            Algorithm algorithm = Algorithm.HMAC256("my-secret");

            return JWT.require(algorithm)
                    .withIssuer("vistaBlog")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {

            return "";

        }

    }

    private Instant getExpirationDate() {

        return LocalDateTime.now()

                .plusHours(8)
                .toInstant(ZoneOffset.of("-03:00"));

    }


}
