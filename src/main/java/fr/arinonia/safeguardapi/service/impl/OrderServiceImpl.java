package fr.arinonia.safeguardapi.service.impl;

import fr.arinonia.safeguardapi.entity.Order;
import fr.arinonia.safeguardapi.repository.OrderRepository;
import fr.arinonia.safeguardapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
