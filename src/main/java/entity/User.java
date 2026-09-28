package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int id;

public class User {
    private int id;
    private String username;
    private String email;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}