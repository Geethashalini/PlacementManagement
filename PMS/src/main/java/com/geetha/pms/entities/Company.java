package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class representing a Company.
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    private Integer id;
    private String name;
    private Float salary;

    @OneToMany(mappedBy = "company")
    private Set<Student> placedStudents = new HashSet<>();  // Use Set to avoid duplicate entries

    /**
     * Default constructor.
     */
    public Company() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param id     the company ID
     * @param name   the company name
     * @param salary the salary package offered by the company
     */
    public Company(Integer id, String name, Float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Set<Student> getPlacedStudents() {
        return placedStudents;
    }

    public void setPlacedStudents(Set<Student> placedStudents) {
        this.placedStudents = placedStudents;
    }

    /**
     * Returns a string representation of the Company.
     *
     * @return a string representing the Company
     */
    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
