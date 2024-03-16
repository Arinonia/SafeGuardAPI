package fr.arinonia.safeguardapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.arinonia.safeguardapi.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInfoDto {

    private Long id;
    private OrderType type;
    private String projectName;
    private String clientName;
    private String clientDiscordId;
    private String clientEmail;
    private BigDecimal price;
    private PaymentMethod paymentMethod;
    private LocalDate startedAt;
    private LocalDate deadline;
    private LocalDate finishedAt;
    private LocalDate deliveredAt;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;

    public OrderInfoDto(final Long id, final OrderType type, final String projectName, final String clientName,
                        final String clientDiscordId, final String clientEmail, final BigDecimal price,
                        final PaymentMethod paymentMethod, final LocalDate startedAt, final LocalDate deadline,
                        final LocalDate finishedAt, final LocalDate deliveredAt, final OrderStatus orderStatus,
                        final PaymentStatus paymentStatus) {
        this.id = id;
        this.type = type;
        this.projectName = projectName;
        this.clientName = clientName;
        this.clientDiscordId = clientDiscordId;
        this.clientEmail = clientEmail;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.startedAt = startedAt;
        this.deadline = deadline;
        this.finishedAt = finishedAt;
        this.deliveredAt = deliveredAt;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }

    public OrderInfoDto() {}

    public static OrderInfoDto fromOrder(final Order order) {
        return new OrderInfoDto(
                order.getId(),
                order.getType(),
                order.getProjectName(),
                order.getClientName(),
                order.getClientDiscordId(),
                order.getClientEmail(),
                order.getPrice(),
                order.getPaymentMethod(),
                order.getStartedAt(),
                order.getDeadline(),
                order.getFinishedAt(),
                order.getDeliveredAt(),
                order.getOrderStatus(),
                order.getPaymentStatus());
    }

    public static OrderInfoDto fromOrderWithPaymentStatusOnly(final Order order) {
        final OrderInfoDto dto = new OrderInfoDto();
        dto.setPaymentStatus(order.getPaymentStatus());
        return dto;
    }

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
}
