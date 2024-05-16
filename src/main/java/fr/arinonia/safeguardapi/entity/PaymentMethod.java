package fr.arinonia.safeguardapi.entity;

/**
 * Enumeration representing the various payment methods that can be used for an order.
 * <p>
 * This enum is used to specify the payment method for an order, such as PayPal, PaySafeCard, bank transfer, or other.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
public enum PaymentMethod {
    /**
     * Indicates payment via PayPal.
     */
    PAYPAL,

    /**
     * Indicates payment via PaySafeCard.
     */
    PAYSAFE_CARD,

    /**
     * Indicates payment via bank transfer.
     */
    BANK,

    /**
     * Indicates payment via any other method not specified above.
     */
    OTHER
}
