package fr.arinonia.safeguardapi.service.impl;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.OrderStatus;
import fr.arinonia.safeguardapi.entity.OrderType;
import fr.arinonia.safeguardapi.repository.OrderRepository;
import fr.arinonia.safeguardapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(final Order order) {
        System.out.println(order.toString());
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order getOrderById(final Long id) {
        return this.orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    @Override
    public Order updateOrder(final Order order) {
        if (order.getId() == null || !this.orderRepository.existsById(order.getId())) {
            throw new RuntimeException("Order with id " + order.getId() + " not found");
        }
        return this.orderRepository.save(order);
    }

    @Override
    public void deleteOrder(final Long id) {
        if (!this.orderRepository.existsById(id)) {
            throw new RuntimeException("Order with id " + id + " not found");
        }
        this.orderRepository.deleteById(id);
    }

    /**
     * Calculates the completion time of an order as a period between the start date and the delivery date.
     * This method is intended to provide insight into how long an order took from start to finish.
     *
     * @param order The order for which the completion time is to be calculated. Must not be {@code null}.
     * @return A {@link Period} representing the time elapsed from the order's start date to its delivery date.
     *         Returns {@code null} if either the start date or the delivery date of the order is not set,
     *         indicating that the completion time cannot be calculated.
     * @apiNote This method uses {@link java.time.LocalDate} for calculating the period, hence only considers dates,
     *          not the specific time of day.
     */
    @Nullable
    @Override
    public Period getCompletionTime(final Order order) {
        if (order.getStartedAt() != null && order.getDeliveredAt() != null) {
            if (order.getOrderStatus() != null && order.getOrderStatus() != OrderStatus.FINISHED) {
                System.err.println("WARN that order is not finished yet");
            }
            return Period.between(order.getStartedAt(), order.getDeliveredAt());
        }
        return null;
    }

    /**
     * Calculates the average price for each order type among all orders.
     * This method aggregates prices for each distinct order type and computes the average price.
     * It iterates over all orders, categorizing them by their type and collecting their prices.
     * After gathering all prices per order type, it calculates the average price for each type
     * by summing all prices and dividing by the count of prices for that type. The calculation
     * employs {@link RoundingMode#HALF_UP} to ensure a standard rounding behavior.
     *
     * @return A {@link Map} where each key is an {@link OrderType} representing a distinct order type,
     *         and each value is a {@link BigDecimal} representing the average price of orders of that type.
     *         If there are no orders for a specific type, that type will not appear in the map. The method
     *         returns an empty map if there are no orders.
     *
     * @implNote This method assumes that all orders have a non-null price. Orders with null prices will
     *           lead to {@link NullPointerException}. It also assumes that {@link #getAllOrders()} does not
     *           return null. The average calculation rounds to the nearest number using {@link RoundingMode#HALF_UP}.
     *           This method may not be efficient for a very large number of orders due to its use of stream
     *           operations and temporary collections.
     */
    @Override
    public Map<OrderType, BigDecimal> averagePrice() {
        final Map<OrderType, List<BigDecimal>> pricesByType = new HashMap<>();

        getAllOrders().forEach(order -> {
            final OrderType type = order.getType();
            final BigDecimal price = order.getPrice();
            pricesByType.computeIfAbsent(type, k -> new ArrayList<>()).add(price);
        });

        final Map<OrderType, BigDecimal> averagePriceByType = new HashMap<>();
        pricesByType.forEach((type, prices) -> {
            final BigDecimal total = prices.stream().reduce(BigDecimal.ONE, BigDecimal::add);
            final BigDecimal average = total.divide(BigDecimal.valueOf(prices.size()), RoundingMode.HALF_UP);
            averagePriceByType.put(type, average);
        });
        return averagePriceByType;
    }
}
