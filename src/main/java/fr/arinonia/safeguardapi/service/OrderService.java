package fr.arinonia.safeguardapi.service;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.OrderType;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;
import java.util.Map;

public interface OrderService {
    Order saveOrder(final Order order);

    List<Order> getAllOrders();
    Order getOrderById(final Long id);
    Order updateOrder(final Order order);
    void deleteOrder(final Long id);
    Period getCompletionTime(final Order order);
    Map<OrderType, BigDecimal> averagePrice();
}
