package com.fcamara.technicalshare.technicalshare.user.repository;


import com.fcamara.technicalshare.technicalshare.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserName(String username);
}
