package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
/**
 * Represents a user account in RecipeForge.
 * @author dweise
 */
public class User {

    /** The user's database ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /** The user's username. */
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    /** The user's email address. */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /** The user's stored password hash. */
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    /** Required by Hibernate. */
    public User() {
    }

    /** Creates a user with the given account information. */
    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    /** @return the user's ID */
    public int getId() {
        return id;
    }

    /** @return the user's username */
    public String getUsername() {
        return username;
    }

    /** Sets the user's username. */
    public void setUsername(String username) {
        this.username = username;
    }

    /** @return the user's email */
    public String getEmail() {
        return email;
    }

    /** Sets the user's email. */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return the user's password hash */
    public String getPasswordHash() {
        return passwordHash;
    }

    /** Sets the user's password hash. */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}