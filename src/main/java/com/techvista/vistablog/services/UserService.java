package com.techvista.vistablog.services;

import com.techvista.vistablog.models.UserModel;
import java.util.List;

public interface UserService {

    UserModel save(UserModel user);

    List<UserModel> getAll();

    UserModel get(Long userId);

    UserModel update(Long userId, UserModel user);

    void delete(Long userId);

}
