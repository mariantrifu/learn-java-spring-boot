package com.learnjavaspringboot.restapilearning.repository;

import com.learnjavaspringboot.restapilearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
