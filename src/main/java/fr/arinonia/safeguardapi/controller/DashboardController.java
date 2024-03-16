package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.OrderService;
import fr.arinonia.safeguardapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

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

    @GetMapping("/editOrder/{id}")
    public String showEditOrderForm(final @PathVariable("id") long id, final Model model) {
        final Order order = this.orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "edit-order";
    }

    @PostMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable("id") long id, @Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            order.setId(id);
            return "edit-order";
        }

        this.orderService.saveOrder(order);
        model.addAttribute("orders", orderService.getAllOrders());
        return "redirect:/dashboard";
    }
}
