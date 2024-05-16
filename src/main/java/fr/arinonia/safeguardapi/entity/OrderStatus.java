package fr.arinonia.safeguardapi.entity;

/**
 * Enumeration representing the various statuses that an order can have.
 * <p>
 * This enum is used to track the current state of an order, such as whether it has been started, finished, or canceled.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
public enum OrderStatus {
    /**
     * Indicates that the order has not been started yet.
     */
    NOT_STARTED,

    /**
     * Indicates that the order has been started.
     */
    STARTED,

    /**
     * Indicates that the order is currently in the testing phase.
     */
    IN_TEST,

    /**
     * Indicates that the order has been finished.
     */
    FINISHED,

    /**
     * Indicates that the order has been canceled.
     */
    CANCELED
}
