package fr.arinonia.safeguardapi.service.impl;

import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.repository.UserRepository;
import fr.arinonia.safeguardapi.service.UserService;
import fr.arinonia.safeguardapi.service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(final User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(final Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(final User userDetails, final Long id) {
        return this.userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setCreationDate(userDetails.getCreationDate());
            user.setUsing2fa(userDetails.isUsing2fa());
            return this.userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public void deleteUser(final Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Response registerUser(final String username, final String email, final String password, final String cPassword) {
        final Response response = new Response();

        if (!password.equals(cPassword)) {
            response.setSuccess(false);
            response.setErrorMessage("Passwords do not match.");
            return response;
        }

        if (password.length() < 7) {
            response.setSuccess(false);
            response.setErrorMessage("Your password size must be higher than 7");
            return response;
        }

        if (this.userRepository.findByUsername(username).isPresent()) {
            response.setSuccess(false);
            response.setErrorMessage("User already exists with the same name");
            return response;
        }

        if (this.userRepository.findByEmail(email).isPresent()) {
            response.setSuccess(false);
            response.setErrorMessage("User already exists with the same email");
            return response;
        }
        final User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(this.passwordEncoder.encode(password));
        newUser.setCreationDate(LocalDateTime.now());
        newUser.setUsing2fa(false);
        this.userRepository.save(newUser);
        response.setSuccess(true);
        return response;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
