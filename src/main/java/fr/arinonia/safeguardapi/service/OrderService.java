package fr.arinonia.safeguardapi.service;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.entity.OrderType;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * Saves the given {@link Order}.
     *
     * @param order the order to save.
     * @return the saved order.
     */
    Order saveOrder(final Order order);

    /**
     * Retrieves all orders.
     *
     * @return a list of all orders.
     */
    List<Order> getAllOrders();

    /**
     * Retrieves an order by its ID.
     *
     * @param id the ID of the order to retrieve.
     * @return the order with the given ID.
     */
    Order getOrderById(final Long id);

    /**
     * Updates the given {@link Order}.
     *
     * @param order the order to update.
     * @return the updated order.
     */
    Order updateOrder(final Order order);

    /**
     * Deletes the order with the given ID.
     *
     * @param id the ID of the order to delete.
     */
    void deleteOrder(final Long id);

    /**
     * Calculates the completion time for the given {@link Order}.
     *
     * @param order the order to calculate the completion time for.
     * @return the completion time as a {@link Period}.
     */
    Period getCompletionTime(final Order order);

    /**
     * Calculates the average price of orders grouped by {@link OrderType}.
     *
     * @return a map where the key is the {@link OrderType} and the value is the average price as a {@link BigDecimal}.
     */
    Map<OrderType, BigDecimal> averagePrice();
}
