package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a Certificate.
 */
@Entity
@Table(name = "certificate")
public class Certificate {

    

	@Id
    private Integer id;
    private int year;

    @ManyToOne
    private College college;

    /**
     * Default constructor.
     */
    public Certificate() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param id    the certificate ID
     * @param year  the year of certification
     * @param college the college that issued the certificate
     */
    public Certificate(Integer id, int year, College college) {
        this.id = id;
        this.year = year;
        this.college = college;
    }

    // Getters and Setters

    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
	}
}

