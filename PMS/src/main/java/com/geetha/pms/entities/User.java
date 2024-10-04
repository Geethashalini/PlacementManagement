package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore // Ignore this field in the JSON output to prevent circular reference
    private List<College> colleges;

    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
    }
}
