package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity class representing a Student.
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    private int id;
    private String name;
    private Long roll;
    private String qualification;
    private String course;
    private int year;
    private Long hallTicketNo;

    @ManyToOne
    @JsonBackReference // Break circular reference with College entity
    private College college;

    @ManyToOne
    private Certificate certificate;
    
    @ManyToOne
    @JsonManagedReference // Ensures proper serialization between Student and Company
    private Company company;

    // Default constructor
    public Student() {
        super();
    }

    // Parameterized constructor
    public Student(int id, String name, Long roll, String qualification, String course, int year, Long hallTicketNo) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.qualification = qualification;
        this.course = course;
        this.year = year;
        this.hallTicketNo = hallTicketNo;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoll() {
        return roll;
    }

    public void setRoll(Long roll) {
        this.roll = roll;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getHallTicketNo() {
        return hallTicketNo;
    }

    public void setHallTicketNo(Long hallTicketNo) {
        this.hallTicketNo = hallTicketNo;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", qualification=" + qualification
                + ", course=" + course + ", year=" + year + ", hallTicketNo=" + hallTicketNo + ", college=" + college
                + ", certificate=" + certificate + "]";
    }
}
