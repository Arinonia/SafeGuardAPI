package fr.arinonia.safeguardapi.entity;

/**
 * Enumeration representing the various types of orders that can be placed.
 * <p>
 * This enum is used to specify the type of order, such as a launcher, mod, plugin, or other.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
public enum OrderType {
    /**
     * Indicates an order for a launcher.
     */
    LAUNCHER,

    /**
     * Indicates an order for an MCP (Minecraft Coder Pack) project.
     */
    MCP,

    /**
     * Indicates an order for an MCP project with Spigot integration.
     */
    MCP_SPIGOT,

    /**
     * Indicates an order for an MCP server project.
     */
    MCP_SERVER,

    /**
     * Indicates an order for a plugin.
     */
    PLUGIN,

    /**
     * Indicates an order for a mod.
     */
    MOD,

    /**
     * Indicates an order for a Discord bot.
     */
    BOT_DISCORD,

    /**
     * Indicates an order for an API.
     */
    API,

    /**
     * Indicates an order for any other type not specified above.
     */
    OTHER
}
