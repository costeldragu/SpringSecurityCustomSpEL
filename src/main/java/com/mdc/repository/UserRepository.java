package com.mdc.repository;

import com.mdc.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserName(String name);

    UserModel findByEmail(String name);
}
