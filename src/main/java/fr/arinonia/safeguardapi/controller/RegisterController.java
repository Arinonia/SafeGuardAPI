package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.dto.UserCommand;
import fr.arinonia.safeguardapi.service.UserService;
import fr.arinonia.safeguardapi.service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerForm(final Model model) {
        model.addAttribute("userCommand", new UserCommand());
        return "register";
    }

    @PostMapping
    public String registerUser(final @ModelAttribute("userCommand") UserCommand userCommand, final RedirectAttributes redirectAttributes) {
        Response response = this.userService.registerUser(userCommand.getUsername(), userCommand.getEmail(), userCommand.getPassword(), userCommand.getConfirmPassword());

        if (!response.isSuccess()) {
            redirectAttributes.addFlashAttribute("errorMessage", response.getErrorMessage());
            return "redirect:/register";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! You can now login.");
        return "redirect:/login";
    }
}