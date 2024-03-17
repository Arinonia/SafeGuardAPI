package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface ILoggedController {
    default String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    default User getCurrentUser(final UserService userService) {
        return userService.findByUsername(getCurrentUsername()).orElseThrow(() -> new IllegalArgumentException("User not found with username '" + getCurrentUsername() + "'"));
    }


}
