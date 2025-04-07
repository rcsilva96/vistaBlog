package com.techvista.vistablog.repositories;

import com.techvista.vistablog.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);

    UserModel findByName(String name);
}
