package com.geetha.pms.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Entity class representing a User.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;
    private String name;
    private String type;
    private String password;

    @OneToMany(mappedBy = "collegeAdmin")
    private List<College> colleges;

    /**
     * Default constructor.
     */
    public User() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param id       the user ID
     * @param name     the user name
     * @param type     the user type (e.g., admin, student)
     * @param password the user's password
     */
    public User(Long id, String name, String type, String password) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.password = password;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }

    /**
     * Returns a string representation of the User.
     *
     * @return a string representing the User
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
    }
}
