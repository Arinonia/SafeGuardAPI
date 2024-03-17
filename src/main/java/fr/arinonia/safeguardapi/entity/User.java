package fr.arinonia.safeguardapi.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDate creationDate;
    private boolean using2fa = false;
    @Enumerated(EnumType.STRING)
    private Rank rank = Rank.USER;
    //private String githubAccessToken;

    public User() {}

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
                "id=" + this.id +
                ", username='" + this.username + '\'' +
                ", email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                ", creationDate=" + this.creationDate +
                ", using2fa=" + this.using2fa +
                ", rank=" + this.rank +
                '}';
    }
}
