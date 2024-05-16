package fr.arinonia.safeguardapi.entity;

/**
 * Enumeration representing the various payment statuses that an order can have.
 * <p>
 * This enum is used to track the current payment status of an order, such as whether it has been paid, half-paid, or is in dispute.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
public enum PaymentStatus {
    /**
     * Indicates that the order has not been paid.
     */
    NOT_PAYED,

    /**
     * Indicates that the order has been fully paid.
     */
    PAYED,

    /**
     * Indicates that the order has been half-paid.
     */
    HALF_PAYED,

    /**
     * Indicates that the payment for the order is in dispute.
     */
    LITIGATE
}
