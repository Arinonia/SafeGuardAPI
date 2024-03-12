package fr.arinonia.safeguardapi.repository;

import fr.arinonia.safeguardapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(final String username);
    Optional<User> findByEmail(final String email);
}
