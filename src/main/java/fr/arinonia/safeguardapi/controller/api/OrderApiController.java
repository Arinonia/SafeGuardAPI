package fr.arinonia.safeguardapi.controller.api;

import fr.arinonia.safeguardapi.dto.OrderInfoDto;
import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.PaymentStatus;
import fr.arinonia.safeguardapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderApiController {
    private OrderService orderService;

    /*
    /api/
        order/{orderId}
        payment_status/{orderId}
        get_orders_by_username/{username}
     */
    @Autowired
    public OrderApiController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public OrderInfoDto getOrderInfo(final @PathVariable Long id) {
        final Order order = this.orderService.getOrderById(id);

        final boolean isFullPaid = this.isOrderPayed(order);

        return new OrderInfoDto(order.getId(), order.getType().name(), isFullPaid);
    }

    private boolean isOrderPayed(final Order order) {
        return order.getPaymentStatus() == PaymentStatus.PAYED;
    }


}
