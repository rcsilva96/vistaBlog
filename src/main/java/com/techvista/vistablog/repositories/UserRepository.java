package com.techvista.vistablog.repositories;

import com.techvista.vistablog.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    //TODO: verificar se o nome do método está correto

    UserModel findByName(String name);

    UserDetails findByUsername(String login);
}
