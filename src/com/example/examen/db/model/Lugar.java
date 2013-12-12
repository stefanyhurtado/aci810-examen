package com.example.examen.db.model;

import java.io.Serializable;

public class Lugar implements Serializable {
	public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String name;
	private String description;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Override
	  public String toString() {
	    return this.name + " " + this.description;
	  }

}



