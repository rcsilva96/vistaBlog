package com.techvista.vistablog.services.impl;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.techvista.vistablog.models.UserModel;
import com.techvista.vistablog.repositories.UserRepository;
import com.techvista.vistablog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //TODO: Verificar o erro em passwordEncoder

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //        JsonEncoder passwordEncoder;
    //        String passwordHash = passwordEncoder.encode(user.getPassword());

    @Override
    public UserModel saveUser(final UserModel user) {

        UserModel existingUser = userRepository.findByName(user.getName());
        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException("O usuário já existe!");
        }
        String passwordHash = passwordEncoder.encode(user.getPassword());


        UserModel entity = new UserModel(user.getUserID(), user.getName(), user.getPassword(), user.getEmail(), user.getRole(), user.getUsername());
        UserModel newUser = userRepository.save(entity);
        return newUser;
    }

    @Override
    public List<UserModel> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public UserModel getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public UserModel updateUser(Long userId, UserModel user) {


        UserModel existingUser = userRepository.findById(userId).orElse(null);

        if (Objects.nonNull(existingUser)) {

            String passwordHash = passwordEncoder.encode(user.getPassword());
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);

        }

        return null;

    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);

    }
}