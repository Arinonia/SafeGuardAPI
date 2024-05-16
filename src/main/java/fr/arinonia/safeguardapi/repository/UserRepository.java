package fr.arinonia.safeguardapi.repository;

import fr.arinonia.safeguardapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a {@link User} by their username.
     *
     * @param username the username to search for.
     * @return an {@link Optional} containing the found {@link User}, or {@link Optional#empty()} if no user was found.
     */
    Optional<User> findByUsername(final String username);

    /**
     * Finds a {@link User} by their email.
     *
     * @param email the email to search for.
     * @return an {@link Optional} containing the found {@link User}, or {@link Optional#empty()} if no user was found.
     */
    Optional<User> findByEmail(final String email);
}
