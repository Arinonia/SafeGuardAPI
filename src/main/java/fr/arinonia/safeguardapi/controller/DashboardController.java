package fr.arinonia.safeguardapi.controller;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.User;
import fr.arinonia.safeguardapi.service.OrderService;
import fr.arinonia.safeguardapi.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController implements ILoggedController {

    private final UserService userService;
    private final OrderService orderService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DashboardController(final UserService userService, final OrderService orderService, final PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.orderService = orderService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping()
    public String dashboard(final Model model) {
        final List<User> users = userService.getAllUsers();
        final List<Order> orders = orderService.getAllOrders();

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

    @GetMapping("/editUser/{id}")
    public String showEditUserForm(final @PathVariable("id") long id, final Model model) {
        final User user = this.userService.getUserById(id).orElseThrow();
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/editUser/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model, @RequestParam(required = false) String password) {
        if (result.hasErrors()) {
            user.setId(id);
            System.out.println(result);
            return "edit-user";
        }

        //careful IllegalArgumentException extends RuntimeException
        final User existingUser = this.userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        if (password == null || password.isEmpty()) {
            user.setPassword(existingUser.getPassword());
        } else {
            user.setPassword(this.passwordEncoder.encode(password));
        }
        user.setCreationDate(existingUser.getCreationDate());
        this.userService.saveUser(user);
        model.addAttribute("users", this.userService.getAllUsers());
        return "redirect:/dashboard";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        final String currentUsername = this.getCurrentUsername();

        if (userService.findByUsername(currentUsername).orElseThrow().getId().equals(id)) {
            new SecurityContextLogoutHandler().logout(request, null, null);
        }
        this.userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("successMessage", "Utilisateur supprimé avec succès.");
        return "redirect:/dashboard";
    }
}
