package fr.arinonia.safeguardapi.config;

import fr.arinonia.safeguardapi.entity.Rank;
import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public DataInitializer(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userService.getAllUsers().isEmpty()) {
            final User defaultUser = new User();
            defaultUser.setUsername("admin");
            defaultUser.setEmail("todo@todo.todo");
            defaultUser.setPassword(passwordEncoder.encode("123456789"));
            defaultUser.setRank(Rank.OWNER);
            defaultUser.setCreationDate(LocalDate.now());
            this.userService.saveUser(defaultUser);
            System.out.println("creating default user: " + defaultUser);
        }
    }
}
