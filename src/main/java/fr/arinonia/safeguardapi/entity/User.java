package fr.arinonia.safeguardapi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Represents a user in the system.
 * <p>
 * This entity class maps to the "users" table in the database and includes various fields that represent
 * the details of a user, such as username, email, password, creation date, 2FA usage, and rank.
 * </p>
 *
 * &#64;author Arinonia
 * &#64;version 1.0
 * &#64;since 2024-05-17
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The date when the user account was created.
     */
    private LocalDate creationDate;

    /**
     * Indicates whether the user is using 2-factor authentication.
     */
    private boolean using2fa = false;

    /**
     * The rank of the user.
     */
    @Enumerated(EnumType.STRING)
    private Rank rank = Rank.USER;

    /**
     * Default constructor.
     */
    public User() {}

    // Getter and setter methods

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(final LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isUsing2fa() {
        return this.using2fa;
    }

    public void setUsing2fa(final boolean using2fa) {
        this.using2fa = using2fa;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setRank(final Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                ", using2fa=" + using2fa +
                ", rank=" + rank +
                '}';
    }
}
