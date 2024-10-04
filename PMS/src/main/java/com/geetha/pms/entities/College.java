package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity class representing a College.
 */
@Entity
@Table(name = "college")
public class College {

    @Id
    private int id;
    private String collegeName;
    private String location;

    @OneToMany(mappedBy = "college")
    @JsonManagedReference // This prevents recursive serialization of students in College
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "college_admin_id")
    @JsonBackReference // This prevents recursive serialization of colleges in User (collegeAdmin)
    private User collegeAdmin;

    // Default constructor
    public College() {
        super();
    }

    // Parameterized constructor
    public College(int id, String collegeName, String location, User collegeAdmin) {
        this.id = id;
        this.collegeName = collegeName;
        this.location = location;
        this.collegeAdmin = collegeAdmin;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public User getCollegeAdmin() {
        return collegeAdmin;
    }

    public void setCollegeAdmin(User collegeAdmin) {
        this.collegeAdmin = collegeAdmin;
    }

    @Override
    public String toString() {
        return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + "]";
    }
}
