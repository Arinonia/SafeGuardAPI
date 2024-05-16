package fr.arinonia.safeguardapi.service;

import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.response.Response;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Saves the given {@link User}.
     *
     * @param user the user to save.
     * @return the saved user.
     */
    User saveUser(final User user);

    /**
     * Retrieves all users.
     *
     * @return a list of all users.
     */
    List<User> getAllUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return an {@link Optional} containing the user, or {@link Optional#empty()} if no user was found.
     */
    Optional<User> getUserById(final Long id);

    /**
     * Finds a {@link User} by their username.
     *
     * @param username the username to search for.
     * @return an {@link Optional} containing the user, or {@link Optional#empty()} if no user was found.
     */
    Optional<User> findByUsername(final String username);

    /**
     * Updates the given {@link User}.
     *
     * @param user the user to update.
     * @param id the ID of the user to update.
     * @return the updated user.
     */
    User updateUser(final User user, final Long id);

    /**
     * Deletes the user with the given ID.
     *
     * @param id the ID of the user to delete.
     */
    void deleteUser(final Long id);

    /**
     * Registers a new user with the given details.
     *
     * @param username the username of the new user.
     * @param email the email of the new user.
     * @param password the password of the new user.
     * @param cPassword the confirmation password of the new user.
     * @return a {@link Response} indicating the result of the registration process.
     */
    Response registerUser(final String username, final String email, final String password, final String cPassword);
}
