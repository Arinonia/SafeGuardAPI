package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.dto.UserCommand;
import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController implements ILoggedController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String homePage(final Model model) {
        final User currentUser = this.getCurrentUser(this.userService);
        model.addAttribute("userRank", currentUser.getRank().name());
        return "home";
    }
}
