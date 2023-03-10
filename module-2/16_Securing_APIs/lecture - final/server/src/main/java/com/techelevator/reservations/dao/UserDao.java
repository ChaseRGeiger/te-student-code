package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.security.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findByUsername(String username);

}
