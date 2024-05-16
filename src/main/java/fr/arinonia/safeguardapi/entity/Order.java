package fr.arinonia.safeguardapi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents an order in the system.
 * <p>
 * This entity class maps to the "orders" table in the database and includes various fields that represent
 * the details of an order, such as the project name, client details, price, payment method, and order status.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * The unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The type of the order.
     */
    @Enumerated(EnumType.STRING)
    private OrderType type = OrderType.OTHER;

    /**
     * The name of the project.
     */
    private String projectName;

    /**
     * The name of the client.
     */
    private String clientName;

    /**
     * The Discord ID of the client.
     */
    private String clientDiscordId;

    /**
     * The email of the client.
     */
    private String clientEmail;

    /**
     * The price of the order.
     */
    private BigDecimal price;

    /**
     * The payment method for the order.
     */
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod = PaymentMethod.PAYPAL;

    /**
     * The date when the order was started.
     */
    private LocalDate startedAt;

    /**
     * The deadline for the order.
     */
    private LocalDate deadline;

    /**
     * The date when the order was finished.
     */
    private LocalDate finishedAt;

    /**
     * The date when the order was delivered.
     */
    private LocalDate deliveredAt;

    /**
     * The current status of the order.
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.NOT_STARTED;

    /**
     * The current payment status of the order.
     */
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAYED;

    /**
     * Default constructor.
     */
    public Order() {}

    // Getter and setter methods

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
    public LocalDate getStartedAt() {
        return this.startedAt;
    }
    public void setStartedAt(final LocalDate startedAt) {
        this.startedAt = startedAt;
    }
    public LocalDate getDeadline() {
        return this.deadline;
    }
    public void setDeadline(final LocalDate deadline) {
        this.deadline = deadline;
    }
    public LocalDate getFinishedAt() {
        return this.finishedAt;
    }
    public void setFinishedAt(final LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }
    public LocalDate getDeliveredAt() {
        return this.deliveredAt;
    }
    public void setDeliveredAt(final LocalDate deliveredAt) {
        this.deliveredAt = deliveredAt;
    }
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }
    public void setOrderStatus(final OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }
    public void setPaymentStatus(final PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type=" + type +
                ", projectName='" + projectName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientDiscordId='" + clientDiscordId + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", price=" + price +
                ", paymentMethod=" + paymentMethod +
                ", startedAt=" + startedAt +
                ", deadline=" + deadline +
                ", finishedAt=" + finishedAt +
                ", deliveredAt=" + deliveredAt +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
