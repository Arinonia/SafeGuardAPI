package fr.arinonia.safeguardapi.dto;

/**
 * Data Transfer Object (DTO) for user commands.
 * <p>
 * This class is used to transfer user data during operations such as user registration.
 * It includes various fields that represent the details needed for user commands, such as username, email, password, and confirm password.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
public class UserCommand {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    /**
     * Constructs a new {@code UserCommand} with the specified details.
     *
     * @param username the username of the user.
     * @param email the email of the user.
     * @param password the password of the user.
     * @param confirmPassword the confirmation password of the user.
     */
    public UserCommand(final String username, final String email, final String password, final String confirmPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    /**
     * Default constructor.
     */
    public UserCommand() {}

    // Getter and setter methods

    /**
     * Returns the username of the user.
     *
     * @return the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Returns the email of the user.
     *
     * @return the email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Returns the confirmation password of the user.
     *
     * @return the confirmation password.
     */
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    /**
     * Sets the confirmation password of the user.
     *
     * @param confirmPassword the confirmation password to set.
     */
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
