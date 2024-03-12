package fr.arinonia.safeguardapi.service;

import fr.arinonia.safeguardapi.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(final Order order);

    List<Order> getAllOrders();
    Order getOrderById(final Long id);
    Order updateOrder(final Order order);
    void deleteOrder(final Long id);
}
