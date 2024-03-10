package fr.arinonia.safeguardapi.service;

import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.response.Response;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(final User user);
    List<User> getAllUsers();
    Optional<User> getUserById(final Long id);
    Optional<User> findByUsername(final String username);
    User updateUser(final User user, final Long id);
    void deleteUser(final Long id);
    Response registerUser(final String username, final String email, final String password, final String cPassword);
}