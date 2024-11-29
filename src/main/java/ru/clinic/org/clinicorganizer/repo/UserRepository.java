package ru.clinic.org.clinicorganizer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clinic.org.clinicorganizer.security.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}
