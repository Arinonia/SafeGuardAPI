package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.OrderService;
import fr.arinonia.safeguardapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public DashboardController(final UserService userService, final OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<User> users = userService.getAllUsers();
        List<Order> orders = orderService.getAllOrders();

        model.addAttribute("users", users);
        model.addAttribute("orders", orders);

        return "dashboard"; // Nom du fichier HTML de la vue (sans l'extension .html)
    }
}
