package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.OrderService;
import fr.arinonia.safeguardapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public DashboardController(final UserService userService, final OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping()
    public String dashboard(final Model model) {
        List<User> users = userService.getAllUsers();
        List<Order> orders = orderService.getAllOrders();

        model.addAttribute("users", users);
        model.addAttribute("orders", orders);

        return "dashboard";
    }

    @GetMapping("/create-order")
    public String createOrder() {
        return "dashboard-create-order";
    }

    @GetMapping("/statistics")
    public String statistics() {
        return "todo";
    }

    @GetMapping("/settings")
    public String settings() {
        return "todo";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute Order order, RedirectAttributes redirectAttributes) {
        this.orderService.saveOrder(order);
        redirectAttributes.addFlashAttribute("successMessage", "Commande créée avec succès !");
        return "redirect:/dashboard";
    }
}
