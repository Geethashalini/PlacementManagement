package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * Entity class representing a Placement.
 */
@Entity
@Table(name = "placement")
public class Placement {

    

	@Id
    private int id;
    private String name;
    private LocalDate date;
    private String qualification;
    private int year;

    @ManyToOne
    private College college;

    /**
     * Default constructor.
     */
    public Placement() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param id            the placement ID
     * @param name          the placement name
     * @param date          the placement date
     * @param qualification the required qualification
     * @param year          the year of placement
     */
    public Placement(int id, String name, LocalDate date, String qualification, int year) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.qualification = qualification;
        this.year = year;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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
			return "Placement [id=" + id + ", name=" + name + ", date=" + date + ", qualification=" + qualification
					+ ", year=" + year + ", college=" + college + "]";
		}
}

