package com.techvista.vistablog.services.impl;

import com.techvista.vistablog.models.UserModel;
import com.techvista.vistablog.repositories.UserRepository;
import com.techvista.vistablog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserModel save(final UserModel user) {
        UserModel existingUser = userRepository.findByUsername(user.getUserName());
        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException("O usuário já existe!");
        }

        UserModel entity = new UserModel(user.getUserID(), user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());
        UserModel newUser = userRepository.save(entity);
        return newUser;
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public UserModel updateUser(Long userId, UserModel user) {
        UserModel existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}