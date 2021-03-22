package com.example.elevator.repository;

import com.example.elevator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {

}
