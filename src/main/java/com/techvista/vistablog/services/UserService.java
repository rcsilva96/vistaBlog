package com.techvista.vistablog.services;

import com.techvista.vistablog.models.UserModel;
import java.util.List;

public interface UserService {

    UserModel saveUser(UserModel user);

    List<UserModel> getAllUsers();

    UserModel getUser(Long userId);

    UserModel updateUser(Long userId, UserModel user);

    void deleteUser(Long userId);

}
