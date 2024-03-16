package fr.arinonia.safeguardapi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private LocalDate startedAt;
    private LocalDate deadline;
    private LocalDate finishedAt;
    private LocalDate deliveredAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.NOT_STARTED;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAYED;

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
