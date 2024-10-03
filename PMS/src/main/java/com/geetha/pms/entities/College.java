package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

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
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "college_admin_id")
    private User collegeAdmin;

    /**
     * Default constructor.
     */
    public College() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param id           the college ID
     * @param collegeName  the name of the college
     * @param location     the location of the college
     * @param collegeAdmin the admin user of the college
     */
    public College(int id, String collegeName, String location, User collegeAdmin) {
        this.id = id;
        this.collegeName = collegeName;
        this.location = location;
        this.collegeAdmin = collegeAdmin;
    }

    // Getters and Setters

    /**
     * Returns the college ID.
     *
     * @return the college ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the college ID.
     *
     * @param id the college ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the college.
     *
     * @return the college name
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * Sets the name of the college.
     *
     * @param collegeName the college name
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * Returns the location of the college.
     *
     * @return the college location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the college.
     *
     * @param location the college location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the list of students enrolled in the college.
     *
     * @return the list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students enrolled in the college.
     *
     * @param students the list of students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Returns the college admin user.
     *
     * @return the college admin
     */
    public User getCollegeAdmin() {
        return collegeAdmin;
    }

    /**
     * Sets the college admin user.
     *
     * @param collegeAdmin the college admin user
     */
    public void setCollegeAdmin(User collegeAdmin) {
        this.collegeAdmin = collegeAdmin;
    }

    /**
     * Returns a string representation of the College.
     *
     * @return a string representing the College
     */
    @Override
    public String toString() {
        return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + "]";
    }
}
