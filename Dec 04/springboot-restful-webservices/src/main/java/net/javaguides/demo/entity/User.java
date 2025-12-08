package net.javaguides.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter     // Lombok generates getters
@Setter     // Lombok generates setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    // -----------------------------
    // OPTIONAL: Custom Getter/Setters
    // -----------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName != null ? firstName.trim() : null;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName != null ? lastName.trim() : null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public String getEmail() {
        return email != null ? email.toLowerCase().trim() : null;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase().trim();
    }

    // Custom helper method
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
