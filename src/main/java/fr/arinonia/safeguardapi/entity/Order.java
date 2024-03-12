package fr.arinonia.safeguardapi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderType type = OrderType.OTHER;
    private String projectName;
    private String clientName;
    private String clientDiscordId;
    private String clientEmail;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod = PaymentMethod.PAYPAL;
    private LocalDateTime startedAt;
    private LocalDateTime deadline;
    private LocalDateTime finishedAt;
    private LocalDateTime deliveredAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.NOT_STARTED;

    public Order() {}

    public Long getId() {
        return this.id;
    }
    public void setId(final Long id) {
        this.id = id;
    }
    public OrderType getType() {
        return this.type;
    }
    public void setType(final OrderType type) {
        this.type = type;
    }
    public String getProjectName() {
        return this.projectName;
    }
    public void setProjectName(final String projectName) {
        this.projectName = projectName;
    }
    public String getClientName() {
        return this.clientName;
    }
    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }
    public String getClientDiscordId() {
        return this.clientDiscordId;
    }
    public void setClientDiscordId(final String clientDiscordId) {
        this.clientDiscordId = clientDiscordId;
    }
    public String getClientEmail() {
        return this.clientEmail;
    }
    public void setClientEmail(final String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
    public void setPaymentMethod(final PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public LocalDateTime getStartedAt() {
        return this.startedAt;
    }
    public void setStartedAt(final LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }
    public LocalDateTime getDeadline() {
        return this.deadline;
    }
    public void setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }
    public void setFinishedAt(final LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }
    public LocalDateTime getDeliveredAt() {
        return this.deliveredAt;
    }
    public void setDeliveredAt(final LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }
    public void setOrderStatus(final OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
