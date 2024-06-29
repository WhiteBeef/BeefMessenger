package ru.whitebeef.beefmessenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.whitebeef.beefmessenger.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
