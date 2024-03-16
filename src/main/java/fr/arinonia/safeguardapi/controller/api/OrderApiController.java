package fr.arinonia.safeguardapi.controller.api;

import fr.arinonia.safeguardapi.dto.OrderInfoDto;
import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.OrderStatus;
import fr.arinonia.safeguardapi.entity.PaymentStatus;
import fr.arinonia.safeguardapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrderApiController {
    private final OrderService orderService;

    /*
    /api/
        order/{orderId}
        payment_status/{orderId}
        get_orders_by_username/{username}
        get_urgency_orders/
     */
    @Autowired
    public OrderApiController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public OrderInfoDto getOrderInfo(final @PathVariable Long id) {
        final Order order = this.orderService.getOrderById(id);
        return OrderInfoDto.fromOrder(order);
    }

    @GetMapping("/orderPaymentStatus/{id}")
    public OrderInfoDto getOrderPaymentStatus(final @PathVariable Long id) {
        final Order order = this.orderService.getOrderById(id);
        return OrderInfoDto.fromOrderWithPaymentStatusOnly(order);
    }

    @GetMapping("/urgencyOrders")
    public List<OrderInfoDto> getUrgencyOrders() {
        final LocalDate now = LocalDate.now();

        final List<Order> orders = this.orderService.getAllOrders();
        final List<Order> urgencyOrders = orders.stream()
                .filter(order -> order.getDeadline() != null &&
                        ChronoUnit.WEEKS.between(now, order.getDeadline()) < 2 &&
                        order.getOrderStatus() != OrderStatus.FINISHED)
                .sorted(Comparator.comparing(Order::getDeadline))
                .limit(10)
                .toList();
        return urgencyOrders.stream().map(OrderInfoDto::fromOrder).collect(Collectors.toList());
    }
}
