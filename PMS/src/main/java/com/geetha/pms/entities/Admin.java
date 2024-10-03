package com.geetha.pms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity class representing an Admin.
 */
@Entity
@Table(name = "admin")
public class Admin {

    

	@Id
    private Integer id;
    private String name;
    private String password;

    /**
     * Default constructor.
     */
    public Admin() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param id       the admin ID
     * @param name     the admin name
     * @param password the admin password
     */
    public Admin(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}

