package fr.arinonia.safeguardapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.arinonia.safeguardapi.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for {@link Order} entities.
 * <p>
 * This class is used to transfer order data between different layers of the application.
 * It includes various fields that represent the details of an order, such as project name, client details, price, payment method, and order status.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
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

    /**
     * Constructs a new {@code OrderInfoDto} with the specified details.
     *
     * @param id the ID of the order.
     * @param type the type of the order.
     * @param projectName the name of the project.
     * @param clientName the name of the client.
     * @param clientDiscordId the Discord ID of the client.
     * @param clientEmail the email of the client.
     * @param price the price of the order.
     * @param paymentMethod the payment method for the order.
     * @param startedAt the date when the order was started.
     * @param deadline the deadline for the order.
     * @param finishedAt the date when the order was finished.
     * @param deliveredAt the date when the order was delivered.
     * @param orderStatus the status of the order.
     * @param paymentStatus the payment status of the order.
     */
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

    /**
     * Default constructor.
     */
    public OrderInfoDto() {}

    /**
     * Creates an {@code OrderInfoDto} from the given {@link Order}.
     *
     * @param order the order to convert.
     * @return the created {@code OrderInfoDto}.
     */
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

    /**
     * Creates an {@code OrderInfoDto} from the given {@link Order}, including only the payment status.
     *
     * @param order the order to convert.
     * @return the created {@code OrderInfoDto} with only the payment status.
     */
    public static OrderInfoDto fromOrderWithPaymentStatusOnly(final Order order) {
        final OrderInfoDto dto = new OrderInfoDto();
        dto.setPaymentStatus(order.getPaymentStatus());
        return dto;
    }

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
}
